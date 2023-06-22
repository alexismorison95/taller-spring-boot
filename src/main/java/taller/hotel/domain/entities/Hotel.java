package taller.hotel.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer HotelId;

    private String Name;

    private String Description;

    @OneToMany(mappedBy = "Hotel", fetch = FetchType.LAZY)
    private List<HotelPhoto> HotelPhotos;

    public Hotel() {
    }

    public Hotel(Integer hotelId, String name, String description, List<HotelPhoto> hotelPhotos) {
        HotelId = hotelId;
        Name = name;
        Description = description;
        HotelPhotos = hotelPhotos;
    }

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

    public List<HotelPhoto> getHotelPhotos() {
        return HotelPhotos;
    }

    public void setHotelPhotos(List<HotelPhoto> hotelPhotos) {
        HotelPhotos = hotelPhotos;
    }

    public void addHotelPhoto(HotelPhoto hotelPhoto) {
        HotelPhotos.add(hotelPhoto);
    }

    public void removeHotelPhoto(HotelPhoto hotelPhoto) {
        HotelPhotos.remove(hotelPhoto);
    }
}
