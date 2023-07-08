package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer extends AuditableEntity {

    @Column(nullable=false)
    private String customerSourceId;

    private String name;

    private String lastName;

    private String dni;

    private String email;

    private Date birthdate;

    private String phoneNumber;

    private Boolean registrationCompleted;

    @Column(nullable=false)
    private Integer registrationMethodId;

    @ManyToOne
    @JoinColumn(name = "registrationMethodId", insertable=false, updatable=false)
    private RegistrationMethod registrationMethod;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Favorite> favorites;

    public Customer() {
    }

    public Customer(Integer id, Date createdDate, String customerSourceId, String name, String lastName, String dni, String email, Date birthdate, String phoneNumber, Boolean registrationCompleted, Integer registrationMethodId) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.customerSourceId = customerSourceId;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.registrationCompleted = registrationCompleted;
        this.registrationMethodId = registrationMethodId;
    }

    public String getCustomerSourceId() {
        return customerSourceId;
    }

    public void setCustomerSourceId(String customerSourceId) {
        this.customerSourceId = customerSourceId;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getRegistrationCompleted() {
        return registrationCompleted;
    }

    public void setRegistrationCompleted(Boolean registrationCompleted) {
        this.registrationCompleted = registrationCompleted;
    }

    public Integer getRegistrationMethodId() {
        return registrationMethodId;
    }

    public void setRegistrationMethodId(Integer registrationMethodId) {
        this.registrationMethodId = registrationMethodId;
    }

    public RegistrationMethod getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(RegistrationMethod registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
