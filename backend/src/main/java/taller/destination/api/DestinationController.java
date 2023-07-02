package taller.destination.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller.destination.application.dtos.DestinationDto;
import taller.destination.application.dtos.DestinationInsertDto;
import taller.destination.application.dtos.DestinationUpdateDto;
import taller.destination.application.services.IDestinationService;
import taller.hotel.api.HotelController;
import taller.hotel.application.dtos.hotel.HotelDto;
import taller.hotel.application.dtos.hotel.HotelInsertDto;
import taller.hotel.application.dtos.hotel.HotelUpdateDto;
import taller.shared.application.Exception.ResourceNotFoundException;

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
}
