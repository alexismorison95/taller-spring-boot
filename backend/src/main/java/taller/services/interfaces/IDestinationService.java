package taller.services.interfaces;

import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.dtos.destinationPhoto.DestinationPhotoDto;
import taller.dtos.destinationPhoto.DestinationPhotoInsertDto;
import taller.dtos.destinationPhoto.DestinationPhotoUpdateDto;
import taller.dtos.hotelPhoto.HotelPhotoDto;
import taller.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.utils.ResourceNotFoundException;

import java.util.List;

public interface IDestinationService {

    List<DestinationDto> getAllDestiantions();

    DestinationDto getDestinationById(Integer id) throws ResourceNotFoundException;

    DestinationDto insertDestination(DestinationInsertDto destinationDto);

    DestinationDto updateDestination(DestinationUpdateDto destinationDto) throws ResourceNotFoundException;

    void deleteDestinationById(Integer id);

    List<DestinationPhotoDto> getDestinationPhotosByDestinationId(Integer id) throws ResourceNotFoundException;

    DestinationPhotoDto insertDestinationPhoto(DestinationPhotoInsertDto dto, Integer destinationId) throws ResourceNotFoundException;

    DestinationPhotoDto updateDestinationPhoto(DestinationPhotoUpdateDto dto, Integer destinationId) throws ResourceNotFoundException;

    void deleteDestinationPhotoById(Integer id);
}
