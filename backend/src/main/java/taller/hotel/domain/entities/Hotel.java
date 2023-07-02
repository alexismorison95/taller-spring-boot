package taller.hotel.domain.entities;

import jakarta.persistence.*;
import taller.destination.domain.entities.Destination;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;

    private String description;

    @Column(nullable=false)
    private Date createdDate;

    private Date lastUpdatedDate;

    @Column(nullable=false)
    private Integer destinationId;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<HotelPhoto> hotelPhotos;

    @ManyToOne
    @JoinColumn(name = "destinationId", insertable=false, updatable=false)
    private Destination destination;

    public Hotel() {
    }

    public Hotel(Integer id, String name, String description, Date createdDate, Integer destinationId, Set<HotelPhoto> hotelPhotos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.destinationId = destinationId;
        this.hotelPhotos = hotelPhotos;
    }

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

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Set<HotelPhoto> getHotelPhotos() {
        return hotelPhotos;
    }

    public void setHotelPhotos(Set<HotelPhoto> hotelPhotos) {
        this.hotelPhotos = hotelPhotos;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
