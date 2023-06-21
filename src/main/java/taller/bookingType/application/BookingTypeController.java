package taller.bookingType.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import taller.bookingType.domain.BookingType;
import taller.bookingType.domain.IBookingTypeRepository;
import taller.shared.application.Exception.ResourceNotFoundException;

import java.util.List;

@RestController
public class BookingTypeController {

    @Autowired
    private IBookingTypeRepository _bookingTypeRepository;

    @GetMapping("/bookingTypes")
    public ResponseEntity<List<BookingType>> getAll() {

        return ResponseEntity
            .ok(_bookingTypeRepository.findAll());
    }

    @GetMapping("/bookingTypes/{id}")
    ResponseEntity<BookingType> findOrderById(@PathVariable Integer id) throws ResourceNotFoundException {

        BookingType bookingType = _bookingTypeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Bookeng Type not found for this id :: " + id));

        return ResponseEntity.ok().body(bookingType);
    }
}
