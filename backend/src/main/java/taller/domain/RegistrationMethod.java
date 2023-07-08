package taller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import taller.domain.base.BaseEntity;

import java.util.Date;

@Entity
@Table(name = "RegistrationMethod")
public class RegistrationMethod extends BaseEntity {

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Date createdDate;

    public RegistrationMethod() {
    }

    public RegistrationMethod(Integer id,String name, Date createdDate) {
        this.setId(id);
        this.name = name;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
