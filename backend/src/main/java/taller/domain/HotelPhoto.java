package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "HotelPhoto")
public class HotelPhoto extends AuditableEntity {

    @Column(nullable=false)
    private String url;

    private String description;

    @Column(nullable=false)
    private Integer hotelId;

    @ManyToOne
    @JoinColumn(name = "hotelId", insertable=false, updatable=false)
    private Hotel hotel;

    public HotelPhoto() {
    }

    public HotelPhoto(Integer id, String url, String description, Date createdDate, Integer hotelId) {
        this.setId(id);
        this.url = url;
        this.description = description;
        this.setCreatedDate(createdDate);
        this.hotelId = hotelId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
