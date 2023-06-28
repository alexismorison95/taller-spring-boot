package taller.hotel.application.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller.hotel.application.dtos.hotel.HotelDto;
import taller.hotel.application.dtos.hotel.HotelInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoDto;
import taller.hotel.application.dtos.hotel.HotelUpdateDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.hotel.domain.entities.Hotel;
import taller.hotel.domain.entities.HotelPhoto;
import taller.hotel.domain.repositories.interfaces.IHotelPhotoRepository;
import taller.hotel.domain.repositories.interfaces.IHotelRepository;
import taller.shared.application.Exception.ResourceNotFoundException;

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
