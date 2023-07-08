package taller.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;

    private String description;

    @Column(nullable=false)
    private Date createdDate;

    private Date lastUpdatedDate;

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Hotel> hotels;

    public Destination() {}

    public Destination(Integer id, String name, String description, Date createdDate, Date lastUpdatedDate, Set<Hotel> hotels) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.hotels = hotels;
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
}
