package taller.controllers.privates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import taller.dtos.destination.DestinationDto;
import taller.dtos.destination.DestinationInsertDto;
import taller.dtos.destination.DestinationUpdateDto;
import taller.dtos.destinationPhoto.DestinationPhotoDto;
import taller.dtos.destinationPhoto.DestinationPhotoInsertDto;
import taller.dtos.destinationPhoto.DestinationPhotoUpdateDto;
import taller.services.interfaces.IDestinationService;
import taller.utils.ResourceNotFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class DestinationController {

    @Autowired
    private IDestinationService _destinationService;

    private static final Logger _logger = LoggerFactory.getLogger(DestinationController.class);

    @GetMapping("/private/destination")
    public ResponseEntity<List<DestinationDto>> getAllDestinations() {

        var auth =  SecurityContextHolder.getContext().getAuthentication();
        _logger.info("Datos del Usuario: {}", auth.getPrincipal());
        _logger.info("Datos de los Roles {}", auth.getAuthorities());
        _logger.info("Esta autenticado {}", auth.isAuthenticated());


        return ResponseEntity.ok(_destinationService.getAllDestiantions());
    }

    @GetMapping("/private/destination/{id}")
    public ResponseEntity<DestinationDto> getDestinationById(@PathVariable Integer id) throws ResourceNotFoundException {

        DestinationDto destination = _destinationService.getDestinationById(id);

        return ResponseEntity.ok().body(destination);
    }

    @PostMapping("/private/destination")
    public ResponseEntity<DestinationDto> insertDestination(@RequestBody DestinationInsertDto destinationDto) {

        DestinationDto destination = _destinationService.insertDestination(destinationDto);

        return ResponseEntity.ok().body(destination);
    }

    @PutMapping("/private/destination")
    public ResponseEntity<DestinationDto> updateDestination(@RequestBody DestinationUpdateDto destinationDto) throws ResourceNotFoundException {

        DestinationDto destination = _destinationService.updateDestination(destinationDto);

        return ResponseEntity.ok().body(destination);
    }

    @DeleteMapping("/private/destination/{id}")
    public ResponseEntity<?> deleteDestinationById(@PathVariable Integer id) {

        _destinationService.deleteDestinationById(id);

        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/private/destination/{id}/destination-photo")
    public ResponseEntity<List<DestinationPhotoDto>> getDestinationPhotosByHotelId(@PathVariable Integer id) throws ResourceNotFoundException {

        List<DestinationPhotoDto> hotel = _destinationService.getDestinationPhotosByDestinationId(id);

        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping("/private/destination/{id}/destination-photo")
    public ResponseEntity<DestinationPhotoDto> insertDestinationPhoto(@PathVariable Integer id, @RequestBody DestinationPhotoInsertDto dto) throws ResourceNotFoundException {

        DestinationPhotoDto destinationPhoto = _destinationService.insertDestinationPhoto(dto, id);

        return ResponseEntity.ok().body(destinationPhoto);
    }

    @PutMapping("/private/destination/{id}/destination-photo")
    public ResponseEntity<DestinationPhotoDto> updateDestinationPhoto(@PathVariable Integer id, @RequestBody DestinationPhotoUpdateDto dto) throws ResourceNotFoundException {

        DestinationPhotoDto destinationPhoto = _destinationService.updateDestinationPhoto(dto, id);

        return ResponseEntity.ok().body(destinationPhoto);
    }

    @DeleteMapping("/private/destination/destination-photo/{id}")
    public ResponseEntity<?> deleteDestinationPhotoById(@PathVariable Integer id) {

        _destinationService.deleteDestinationPhotoById(id);

        return ResponseEntity.ok().body(id);
    }
}
