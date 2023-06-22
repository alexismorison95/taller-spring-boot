package taller.hotel.application.dtos;

import java.util.ArrayList;
import java.util.List;

public class HotelDto {

    Integer HotelId;

    String Name;

    String Description;

    List<HotelPhotoDto> HotelPhotos = new ArrayList<>();

    public Integer getHotelId() {
        return HotelId;
    }

    public void setHotelId(Integer hotelId) {
        HotelId = hotelId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<HotelPhotoDto> getHotelPhotos() {
        return HotelPhotos;
    }

    public void setHotelPhotos(List<HotelPhotoDto> hotelPhotos) {
        HotelPhotos = hotelPhotos;
    }
}
