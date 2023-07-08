package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Destination")
public class Destination extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Hotel> hotels;

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<DestinationPhoto> destinationPhotos;

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Excursion> excursions;

    public Destination() {}

    public Destination(Integer id, String name, String description, Date createdDate) {
        this.setId(id);
        this.name = name;
        this.description = description;
        this.setCreatedDate(createdDate);
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
}
