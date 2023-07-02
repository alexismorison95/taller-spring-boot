package taller.destination.application.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.destination.application.dtos.DestinationDto;
import taller.destination.application.dtos.DestinationInsertDto;
import taller.destination.application.dtos.DestinationUpdateDto;
import taller.destination.domain.entities.Destination;
import taller.destination.domain.repositories.IDestinationRepository;
import taller.hotel.application.services.HotelService;
import taller.shared.application.Exception.ResourceNotFoundException;

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
            .map(destination -> _modelMapper.map(destination, DestinationDto.class))
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
