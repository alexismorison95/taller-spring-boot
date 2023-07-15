package taller.controllers.privates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller.dtos.hotel.HotelDto;
import taller.dtos.hotel.HotelInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoDto;
import taller.dtos.hotel.HotelUpdateDto;
import taller.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.services.interfaces.IHotelService;
import taller.utils.ResourceNotFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class HotelController {

    @Autowired
    private IHotelService _hotelService;

    private static final Logger _logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/private/hotel")
    public ResponseEntity<List<HotelDto>> getAllHotels() {

        return ResponseEntity.ok(_hotelService.getAllHotels());
    }

    @GetMapping("/private/hotel/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Integer id) throws ResourceNotFoundException {

        HotelDto hotel = _hotelService.getHotelById(id);

        return ResponseEntity.ok().body(hotel);
    }

    @GetMapping("/private/hotel/by-destination/{desinationId}")
    public ResponseEntity<List<HotelDto>> getHotelsByDestinationId(@PathVariable Integer desinationId) throws ResourceNotFoundException  {

        return ResponseEntity.ok(_hotelService.getHotelsByDestinationId(desinationId));
    }

    @PostMapping("/private/hotel")
    public ResponseEntity<HotelDto> insertHotel(@RequestBody HotelInsertDto hotelDto) {

        HotelDto hotel = _hotelService.insertHotel(hotelDto);

        return ResponseEntity.ok().body(hotel);
    }

    @PutMapping("/private/hotel")
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelUpdateDto hotelDto) throws ResourceNotFoundException {

        HotelDto hotel = _hotelService.updateHotel(hotelDto);

        return ResponseEntity.ok().body(hotel);
    }

    @DeleteMapping("/private/hotel/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable Integer id) {

        _hotelService.deleteHotelById(id);

        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/private/hotel/{id}/hotel-photo")
    public ResponseEntity<List<HotelPhotoDto>> getHotelPhotosByHotelId(@PathVariable Integer id) throws ResourceNotFoundException {

        List<HotelPhotoDto> hotel = _hotelService.getHotelPhotosByHotelId(id);

        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping("/private/hotel/{id}/hotel-photo")
    public ResponseEntity<HotelPhotoDto> insertHotelPhoto(@PathVariable Integer id, @RequestBody HotelPhotoInsertDto hotelPhotoDto) throws ResourceNotFoundException {

        HotelPhotoDto hotelPhoto = _hotelService.insertHotelPhoto(hotelPhotoDto, id);

        return ResponseEntity.ok().body(hotelPhoto);
    }

    @PutMapping("/private/hotel/{id}/hotel-photo")
    public ResponseEntity<HotelPhotoDto> updateHotelPhoto(@PathVariable Integer id, @RequestBody HotelPhotoUpdateDto hotelPhotoDto) throws ResourceNotFoundException {

        HotelPhotoDto hotelPhoto = _hotelService.updateHotelPhoto(hotelPhotoDto, id);

        return ResponseEntity.ok().body(hotelPhoto);
    }

    @DeleteMapping("/private/hotel/hotel-photo/{id}")
    public ResponseEntity<?> deleteHotelPhotoById(@PathVariable Integer id) {

        _hotelService.deleteHotelPhotoById(id);

        return ResponseEntity.ok().body(id);
    }
}
