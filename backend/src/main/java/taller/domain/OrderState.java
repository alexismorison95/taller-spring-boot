package taller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "OrderState")
public class OrderState extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    public OrderState() {
    }

    public OrderState(Integer id, String name, Date createdDate) {
        this.name = name;
        this.setId(id);
        this.setCreatedDate(createdDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
