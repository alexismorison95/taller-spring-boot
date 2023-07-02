package taller.destination.application.services;

import taller.destination.application.dtos.DestinationDto;
import taller.destination.application.dtos.DestinationInsertDto;
import taller.destination.application.dtos.DestinationUpdateDto;
import taller.shared.application.Exception.ResourceNotFoundException;

import java.util.List;

public interface IDestinationService {

    List<DestinationDto> getAllDestiantions();

    DestinationDto getDestinationById(Integer id) throws ResourceNotFoundException;

    DestinationDto insertDestination(DestinationInsertDto destinationDto);

    DestinationDto updateDestination(DestinationUpdateDto destinationDto) throws ResourceNotFoundException;

    void deleteDestinationById(Integer id);
}
