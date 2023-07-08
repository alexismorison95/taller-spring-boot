package taller.services.impls;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.domain.Destination;
import taller.repositories.IDestinationRepository;
import taller.dtos.hotel.HotelDto;
import taller.dtos.hotel.HotelInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoDto;
import taller.dtos.hotel.HotelUpdateDto;
import taller.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.domain.Hotel;
import taller.domain.HotelPhoto;
import taller.repositories.IHotelPhotoRepository;
import taller.repositories.IHotelRepository;
import taller.services.interfaces.IHotelService;
import taller.utils.ResourceNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private IHotelRepository _hotelRepository;

    @Autowired
    private IHotelPhotoRepository _hotelPhotoRepository;

    @Autowired
    private IDestinationRepository _destinationRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(HotelService.class);

    @Override
    public List<HotelDto> getAllHotels() {

        return _hotelRepository.findAll()
            .stream()
            .map(hotel -> _modelMapper.map(hotel, HotelDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotelById(Integer id) throws ResourceNotFoundException {

        Hotel hotel = _hotelRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + id));

        return _modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public List<HotelDto> getHotelsByDestinationId(Integer destinationId) throws ResourceNotFoundException {

        Destination destination = _destinationRepository.findById(destinationId)
            .orElseThrow(() -> new ResourceNotFoundException("Destination not found for this id :: " + destinationId));

        List<HotelDto> result = _hotelRepository.findByDestinationId(destinationId)
            .stream()
            .map(hotel -> _modelMapper.map(hotel, HotelDto.class))
            .collect(Collectors.toList());

        return result;
    }

    @Override
    public HotelDto insertHotel(HotelInsertDto hotelDto) {

        Hotel newHotel = _modelMapper.map(hotelDto, Hotel.class);

        newHotel.setCreatedDate(new Date());

        _hotelRepository.save(newHotel);

        return _modelMapper.map(newHotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotel(HotelUpdateDto hotelDto) throws ResourceNotFoundException {

        Hotel hotel = _hotelRepository.findById(hotelDto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelDto.getId()));

        hotel.setName(hotelDto.getName());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setLastUpdatedDate(new Date());

        _hotelRepository.save(hotel);

        return _modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public void deleteHotelById(Integer id) {

        _hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelPhotoDto> getHotelPhotosByHotelId(Integer id) throws ResourceNotFoundException {

        return _hotelPhotoRepository.findByHotelId(id)
            .orElseThrow(() -> new ResourceNotFoundException("HotelPhoto not found for this hotelId :: " + id))
            .stream()
            .map(hotel -> _modelMapper.map(hotel, HotelPhotoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public HotelPhotoDto insertHotelPhoto(HotelPhotoInsertDto hotelPhotoDto, Integer hotelId) throws ResourceNotFoundException {

        Hotel hotel = _hotelRepository.findById(hotelId)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelId));

        HotelPhoto hotelPhoto = _modelMapper.map(hotelPhotoDto, HotelPhoto.class);

        hotelPhoto.setHotel(hotel);
        hotelPhoto.setCreatedDate(new Date());

        _hotelPhotoRepository.save(hotelPhoto);

        return _modelMapper.map(hotelPhoto, HotelPhotoDto.class);
    }

    @Override
    public HotelPhotoDto updateHotelPhoto(HotelPhotoUpdateDto hotelPhotoDto, Integer hotelId) throws ResourceNotFoundException {

        HotelPhoto hotelPhoto = _hotelPhotoRepository.findById(hotelPhotoDto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("HotelPhoto not found for this id :: " + hotelPhotoDto.getId()));

        Hotel hotel = _hotelRepository.findById(hotelId)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelId));

        hotelPhoto.setHotel(hotel);
        hotelPhoto.setUrl(hotelPhotoDto.getUrl());
        hotelPhoto.setDescription(hotelPhotoDto.getDescription());
        hotelPhoto.setLastUpdatedDate(new Date());

        _hotelPhotoRepository.save(hotelPhoto);

        return _modelMapper.map(hotelPhoto, HotelPhotoDto.class);
    }

    @Override
    public void deleteHotelPhotoById(Integer id) {

        _hotelPhotoRepository.deleteById(id);
    }
}
