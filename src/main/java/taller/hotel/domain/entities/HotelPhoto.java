package taller.hotel.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "HotelPhoto")
public class HotelPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer HotelPhotoId;

    private String URL;

    private String Description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HotelId")
    private Hotel Hotel;

    public HotelPhoto() {
    }

    public HotelPhoto(Integer hotelPhotoId, String URL, String description, Hotel hotel) {
        HotelPhotoId = hotelPhotoId;
        this.URL = URL;
        Description = description;
        Hotel = hotel;
    }

    public Integer getHotelPhotoId() {
        return HotelPhotoId;
    }

    public void setHotelPhotoId(Integer hotelPhotoId) {
        HotelPhotoId = hotelPhotoId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public taller.hotel.domain.entities.Hotel getHotel() {
        return Hotel;
    }

    public void setHotel(taller.hotel.domain.entities.Hotel hotel) {
        Hotel = hotel;
    }
}
