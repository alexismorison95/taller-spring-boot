package taller.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.dtos.destinationPhoto.DestinationPhotoDto;
import taller.dtos.destinationPhoto.DestinationPhotoInsertDto;
import taller.dtos.destinationPhoto.DestinationPhotoUpdateDto;
import taller.dtos.hotelPhoto.HotelPhotoDto;
import taller.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.services.interfaces.IDestinationService;
import taller.utils.ResourceNotFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class DestinationController {

    @Autowired
    private IDestinationService _destinationService;

    private static final Logger _logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/destination")
    public ResponseEntity<List<DestinationDto>> getAllDestinations() {

        return ResponseEntity.ok(_destinationService.getAllDestiantions());
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<DestinationDto> getDestinationById(@PathVariable Integer id) throws ResourceNotFoundException {

        DestinationDto destination = _destinationService.getDestinationById(id);

        return ResponseEntity.ok().body(destination);
    }

    @PostMapping("/destination")
    public ResponseEntity<DestinationDto> insertDestination(@RequestBody DestinationInsertDto destinationDto) {

        DestinationDto destination = _destinationService.insertDestination(destinationDto);

        return ResponseEntity.ok().body(destination);
    }

    @PutMapping("/destination")
    public ResponseEntity<DestinationDto> updateDestination(@RequestBody DestinationUpdateDto destinationDto) throws ResourceNotFoundException {

        DestinationDto destination = _destinationService.updateDestination(destinationDto);

        return ResponseEntity.ok().body(destination);
    }

    @DeleteMapping("/destination/{id}")
    public ResponseEntity<?> deleteDestinationById(@PathVariable Integer id) {

        _destinationService.deleteDestinationById(id);

        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/destination/{id}/destination-photo")
    public ResponseEntity<List<DestinationPhotoDto>> getDestinationPhotosByHotelId(@PathVariable Integer id) throws ResourceNotFoundException {

        List<DestinationPhotoDto> hotel = _destinationService.getDestinationPhotosByDestinationId(id);

        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping("/destination/{id}/destination-photo")
    public ResponseEntity<DestinationPhotoDto> insertDestinationPhoto(@PathVariable Integer id, @RequestBody DestinationPhotoInsertDto dto) throws ResourceNotFoundException {

        DestinationPhotoDto destinationPhoto = _destinationService.insertDestinationPhoto(dto, id);

        return ResponseEntity.ok().body(destinationPhoto);
    }

    @PutMapping("/destination/{id}/destination-photo")
    public ResponseEntity<DestinationPhotoDto> updateDestinationPhoto(@PathVariable Integer id, @RequestBody DestinationPhotoUpdateDto dto) throws ResourceNotFoundException {

        DestinationPhotoDto destinationPhoto = _destinationService.updateDestinationPhoto(dto, id);

        return ResponseEntity.ok().body(destinationPhoto);
    }

    @DeleteMapping("/destination/destination-photo/{id}")
    public ResponseEntity<?> deleteDestinationPhotoById(@PathVariable Integer id) {

        _destinationService.deleteDestinationPhotoById(id);

        return ResponseEntity.ok().body(id);
    }
}
