package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Hotel")
public class Hotel extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    private String description;

    @Column(nullable=false)
    private Integer destinationId;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<HotelPhoto> hotelPhotos;

    @ManyToOne
    @JoinColumn(name = "destinationId", insertable=false, updatable=false)
    private Destination destination;

    public Hotel() {
    }

    public Hotel(Integer id, String name, String description, Date createdDate, Integer destinationId) {
        this.setId(id);
        this.name = name;
        this.description = description;
        this.setCreatedDate(createdDate);
        this.destinationId = destinationId;
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
