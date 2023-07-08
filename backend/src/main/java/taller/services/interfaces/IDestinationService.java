package taller.services.interfaces;

import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.utils.ResourceNotFoundException;

import java.util.List;

public interface IDestinationService {

    List<DestinationDto> getAllDestiantions();

    DestinationDto getDestinationById(Integer id) throws ResourceNotFoundException;

    DestinationDto insertDestination(DestinationInsertDto destinationDto);

    DestinationDto updateDestination(DestinationUpdateDto destinationDto) throws ResourceNotFoundException;

    void deleteDestinationById(Integer id);
}
