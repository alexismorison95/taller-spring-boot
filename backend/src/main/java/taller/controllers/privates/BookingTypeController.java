package taller.controllers.privates;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taller.dtos.bookingType.BookingTypeDto;
import taller.domain.BookingType;
import taller.repositories.IBookingTypeRepository;
import taller.utils.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class BookingTypeController {

    @Autowired
    private IBookingTypeRepository _bookingTypeRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(BookingTypeController.class);

    @GetMapping("/private/bookingTypes")
    public ResponseEntity<List<BookingTypeDto>> getAll() {

        List<BookingTypeDto> result = _bookingTypeRepository.findAll()
            .stream()
            .map(bookingType -> _modelMapper.map(bookingType, BookingTypeDto.class))
            .collect(Collectors.toList());

        _logger.info(result.toString());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/private/bookingTypes/{id}")
    ResponseEntity<BookingType> findOrderById(@PathVariable Integer id) throws ResourceNotFoundException {

        BookingType bookingType = _bookingTypeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Bookeng Type not found for this id :: " + id));

        return ResponseEntity.ok().body(bookingType);
    }
}
