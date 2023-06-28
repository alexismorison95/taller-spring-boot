package taller.hotel.application.dtos.hotel;

import org.springframework.stereotype.Component;
import taller.hotel.application.dtos.hotelPhoto.HotelPhotoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class HotelDto {

    Integer id;

    String name;

    String description;

    Date createdDate;

    Date lastUpdatedDate;

    List<HotelPhotoDto> hotelPhotos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<HotelPhotoDto> getHotelPhotos() {
        return hotelPhotos;
    }

    public void setHotelPhotos(List<HotelPhotoDto> hotelPhotos) {
        this.hotelPhotos = hotelPhotos;
    }
}
