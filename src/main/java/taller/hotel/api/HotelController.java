package taller.hotel.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taller.hotel.application.dtos.HotelDto;
import taller.hotel.application.services.HotelService;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService _hotelService;

    private static final Logger _logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> getAllHotels() {

        return ResponseEntity.ok(_hotelService.getAllHotels());
    }
}
