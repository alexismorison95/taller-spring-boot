package taller.services.impls;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.domain.Destination;
import taller.dtos.product.ProductDto;
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
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(HotelService.class);

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
}
