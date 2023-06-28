package taller.hotel.application.services;

import taller.hotel.application.dtos.hotel.HotelDto;
import taller.hotel.application.dtos.hotel.HotelInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoDto;
import taller.hotel.application.dtos.hotel.HotelUpdateDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoInsertDto;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoUpdateDto;
import taller.shared.application.Exception.ResourceNotFoundException;

import java.util.List;

public interface IHotelService {

    /**
     * Obtiene la lista de todos los hoteles
     * @return {@code List<HotelDto>}
     */
    List<HotelDto> getAllHotels();

    /**
     * Obtiene un hotel por su identificador
     * @param id Identificador del hotel
     * @return {@code HotelDto}
     * @throws ResourceNotFoundException En caso de no existir el hotel
     */
    HotelDto getHotelById(Integer id) throws ResourceNotFoundException;

    /**
     * Inserta un hotel
     * @param hotelDto Hotel a insertar
     * @return {@code HotelDto}
     */
    HotelDto insertHotel(HotelInsertDto hotelDto);

    /**
     * Actualiza un hotel
     * @param hotelDto Hotel a actualizar
     * @return {@code HotelDto}
     */
    HotelDto updateHotel(HotelUpdateDto hotelDto) throws ResourceNotFoundException;

    /**
     * Elimina un hotel
     * @param id Identificador del hotel
     */
    void deleteHotelById(Integer id);

    /**
     * Obtiene la lista de las fotografías de un hotel
     * @param id Identificador del hotel
     * @return {@code List<HotelPhotoDto>}
     * @throws ResourceNotFoundException en caso de no existir el hotel
     */
    List<HotelPhotoDto> getHotelPhotosByHotelId(Integer id) throws ResourceNotFoundException;

    /**
     * Agrega una fotografía a un hotel
     * @param hotelPhotoDto Fotografía a insertar
     * @param hotelId Identificador del hotel
     * @return {@code HotelPhotoDto}
     * @throws ResourceNotFoundException
     */
    HotelPhotoDto insertHotelPhoto(HotelPhotoInsertDto hotelPhotoDto, Integer hotelId) throws ResourceNotFoundException;

    /**
     * Actualiza una fotografía a un hotel
     * @param hotelPhotoDto Fotografía a actualizar
     * @param hotelId
     * @return {@code HotelPhotoDto}
     * @throws ResourceNotFoundException
     */
    HotelPhotoDto updateHotelPhoto(HotelPhotoUpdateDto hotelPhotoDto, Integer hotelId) throws ResourceNotFoundException;

    /**
     * Elimina una fotografía de un hotel
     * @param id Identificador de la fotografía
     */
    void deleteHotelPhotoById(Integer id);
}
