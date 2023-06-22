package taller.hotel.application.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.hotel.application.dtos.HotelDto;
import taller.hotel.domain.repositories.IHotelPhotoRepository;
import taller.hotel.domain.repositories.IHotelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private IHotelRepository _hotelRepository;

    @Autowired
    private IHotelPhotoRepository _hotelPhotoRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(HotelService.class);

    public List<HotelDto> getAllHotels() {

        List<HotelDto> result = _hotelRepository.findAll()
            .stream()
            .map(hotel -> _modelMapper.map(hotel, HotelDto.class))
            .collect(Collectors.toList());

        return result;
    }
}
