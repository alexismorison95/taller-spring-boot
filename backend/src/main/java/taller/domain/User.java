package taller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "User")
public class User extends AuditableEntity {

    @Column(nullable=false)
    private String loginName;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private Boolean active;

    private String name;

    private String lastName;

    private String email;

    public User() {
    }

    public User(Integer id, Date createdDate, String loginName, String password, Boolean active, String name, String lastName, String email) {
        this.loginName = loginName;
        this.password = password;
        this.active = active;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.setId(id);
        this.setCreatedDate(createdDate);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
