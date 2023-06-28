package taller.hotel.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller.hotel.application.dtos.hotel.HotelDto;
import taller.hotel.application.dtos.hotel.HotelInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoDto;
import taller.hotel.application.dtos.hotel.HotelUpdateDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.hotel.application.services.IHotelService;
import taller.shared.application.Exception.ResourceNotFoundException;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private IHotelService _hotelService;

    private static final Logger _logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/hotel")
    public ResponseEntity<List<HotelDto>> getAllHotels() {

        return ResponseEntity.ok(_hotelService.getAllHotels());
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Integer id) throws ResourceNotFoundException {

        HotelDto hotel = _hotelService.getHotelById(id);

        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping("/hotel")
    public ResponseEntity<HotelDto> insertHotel(@RequestBody HotelInsertDto hotelDto) {

        HotelDto hotel = _hotelService.insertHotel(hotelDto);

        return ResponseEntity.ok().body(hotel);
    }

    @PutMapping("/hotel")
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelUpdateDto hotelDto) throws ResourceNotFoundException {

        HotelDto hotel = _hotelService.updateHotel(hotelDto);

        return ResponseEntity.ok().body(hotel);
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable Integer id) {

        _hotelService.deleteHotelById(id);

        return ResponseEntity.ok().body("Deleted");
    }

    @GetMapping("/hotel/{id}/hotel-photo")
    public ResponseEntity<List<HotelPhotoDto>> getHotelPhotosByHotelId(@PathVariable Integer id) throws ResourceNotFoundException {

        List<HotelPhotoDto> hotel = _hotelService.getHotelPhotosByHotelId(id);

        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping("/hotel/{id}/hotel-photo")
    public ResponseEntity<HotelPhotoDto> insertHotelPhoto(@PathVariable Integer id, @RequestBody HotelPhotoInsertDto hotelPhotoDto) throws ResourceNotFoundException {

        HotelPhotoDto hotelPhoto = _hotelService.insertHotelPhoto(hotelPhotoDto, id);

        return ResponseEntity.ok().body(hotelPhoto);
    }

    @PutMapping("/hotel/{id}/hotel-photo")
    public ResponseEntity<HotelPhotoDto> updateHotelPhoto(@PathVariable Integer id, @RequestBody HotelPhotoUpdateDto hotelPhotoDto) throws ResourceNotFoundException {

        HotelPhotoDto hotelPhoto = _hotelService.updateHotelPhoto(hotelPhotoDto, id);

        return ResponseEntity.ok().body(hotelPhoto);
    }

    @DeleteMapping("/hotel/hotel-photo/{id}")
    public ResponseEntity<?> deleteHotelPhotoById(@PathVariable Integer id) {

        _hotelService.deleteHotelPhotoById(id);

        return ResponseEntity.ok().body("Deleted");
    }
}
