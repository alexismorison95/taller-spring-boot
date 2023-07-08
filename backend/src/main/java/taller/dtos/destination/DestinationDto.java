package taller.dtos.destination;

import org.springframework.stereotype.Component;
import taller.dtos.hotel.HotelDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DestinationDto {

    Integer id;

    String name;

    String description;

    Integer hotelQuantity;

    Date createdDate;

    Date lastUpdatedDate;

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

    public Integer getHotelQuantity() {
        return hotelQuantity;
    }

    public void setHotelQuantity(Integer hotelQuantity) {
        this.hotelQuantity = hotelQuantity;
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
}
