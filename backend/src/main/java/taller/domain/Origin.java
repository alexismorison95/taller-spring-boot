package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "Origin")
public class Origin extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    public Origin() {
    }

    public Origin(Integer id, String name, Date createdDate) {
        this.setId(id);
        this.name = name;
        this.setCreatedDate(createdDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
