package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Transport")
public class Transport extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    @OneToMany(mappedBy = "transport", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ProductTransport> productTransports;

    public Transport() {
    }

    public Transport(Integer id, String name, Date createdDate) {
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
