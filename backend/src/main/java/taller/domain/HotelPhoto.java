package taller.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "HotelPhoto")
public class HotelPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String url;

    private String description;

    @Column(nullable=false)
    private Date createdDate;

    private Date lastUpdatedDate;

    @Column(nullable=false)
    private Integer hotelId;

    @ManyToOne
    @JoinColumn(name = "hotelId", insertable=false, updatable=false)
    private Hotel hotel;

    public HotelPhoto() {
    }

    public HotelPhoto(Integer id, String url, String description, Date createdDate, Integer hotelId) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.createdDate = createdDate;
        this.hotelId = hotelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
