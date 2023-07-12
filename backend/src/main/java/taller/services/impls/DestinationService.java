package taller.services.impls;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.domain.DestinationPhoto;
import taller.domain.Hotel;
import taller.domain.HotelPhoto;
import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.domain.Destination;
import taller.dtos.destinationPhoto.DestinationPhotoDto;
import taller.dtos.destinationPhoto.DestinationPhotoInsertDto;
import taller.dtos.destinationPhoto.DestinationPhotoUpdateDto;
import taller.dtos.hotelPhoto.HotelPhotoDto;
import taller.dtos.product.ProductDto;
import taller.repositories.IDestinationPhotoRepository;
import taller.repositories.IDestinationRepository;
import taller.services.interfaces.IDestinationService;
import taller.utils.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService implements IDestinationService {

    @Autowired
    private IDestinationRepository _destinationRepository;

    @Autowired
    private IDestinationPhotoRepository _destinationPhotoRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(DestinationService.class);

    @Override
    public List<DestinationDto> getAllDestiantions() {

        return _destinationRepository.findAll()
            .stream()
            .map(destination -> {
                DestinationDto dto = _modelMapper.map(destination, DestinationDto.class);
                dto.setHotelQuantity(destination.getHotels().size());
                return dto;
            })
            .collect(Collectors.toList());
    }

    @Override
    public DestinationDto getDestinationById(Integer id) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + id));

        return _modelMapper.map(destination, DestinationDto.class);
    }

    @Override
    public DestinationDto insertDestination(DestinationInsertDto destinationDto) {

        Destination newdestination = _modelMapper.map(destinationDto, Destination.class);

        newdestination.setCreatedDate(new Date());

        _destinationRepository.save(newdestination);

        return _modelMapper.map(newdestination, DestinationDto.class);
    }

    @Override
    public DestinationDto updateDestination(DestinationUpdateDto destinationDto) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(destinationDto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + destinationDto.getId()));

        destination.setName(destinationDto.getName());
        destination.setDescription(destinationDto.getDescription());
        destination.setLastUpdatedDate(new Date());

        _destinationRepository.save(destination);

        return _modelMapper.map(destination, DestinationDto.class);
    }

    @Override
    public void deleteDestinationById(Integer id) {

        _destinationRepository.deleteById(id);
    }

    @Override
    public List<DestinationPhotoDto> getDestinationPhotosByDestinationId(Integer id) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + id));

        return _destinationPhotoRepository.findByDestinationId(id)
            .stream()
            .map(destinationPhoto -> _modelMapper.map(destinationPhoto, DestinationPhotoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public DestinationPhotoDto insertDestinationPhoto(DestinationPhotoInsertDto dto, Integer destinationId) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(destinationId)
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + destinationId));

        DestinationPhoto destinationPhoto = _modelMapper.map(dto, DestinationPhoto.class);

        destinationPhoto.setDestinationId(destinationId);
        destinationPhoto.setDestination(destination);
        destinationPhoto.setCreatedDate(new Date());

        _destinationPhotoRepository.save(destinationPhoto);

        return _modelMapper.map(destinationPhoto, DestinationPhotoDto.class);
    }

    @Override
    public DestinationPhotoDto updateDestinationPhoto(DestinationPhotoUpdateDto dto, Integer destinationId) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(destinationId)
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + destinationId));

        DestinationPhoto destinationPhoto = _destinationPhotoRepository.findById(dto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("DestinationPhoto not found for this id :: " + dto.getId()));

        destinationPhoto.setUrl(dto.getUrl());
        destinationPhoto.setDescription(dto.getDescription());
        destinationPhoto.setLastUpdatedDate(new Date());

        _destinationPhotoRepository.save(destinationPhoto);

        return _modelMapper.map(destinationPhoto, DestinationPhotoDto.class);
    }

    @Override
    public void deleteDestinationPhotoById(Integer id) {

        _destinationPhotoRepository.deleteById(id);
    }
}
