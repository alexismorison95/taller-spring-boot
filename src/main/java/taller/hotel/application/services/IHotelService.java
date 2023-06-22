package taller.hotel.application.services;

import taller.hotel.application.dtos.HotelDto;

import java.util.List;

public interface IHotelService {

    /**
     * Obtiene la lista de todos los hoteles
     * @return
     */
    List<HotelDto> getAllHotels();
}
