package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "DestinationPhoto")
public class DestinationPhoto extends AuditableEntity {

    @Column(nullable=false)
    private String url;

    private String description;

    @Column(nullable=false)
    private Integer destinationId;

    @ManyToOne
    @JoinColumn(name = "destinationId", insertable=false, updatable=false)
    private Destination destination;

    public DestinationPhoto() {
    }

    public DestinationPhoto(Integer id, String url, String description, Date createdDate, Integer destinationId) {
        this.setId(id);
        this.url = url;
        this.description = description;
        this.setCreatedDate(createdDate);
        this.destinationId = destinationId;
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

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
