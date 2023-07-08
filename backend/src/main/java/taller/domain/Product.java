package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product extends AuditableEntity {

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Date departureDate;

    @Column(nullable=false)
    private Date returnDate;

    @Column(nullable=false)
    private Float price;

    @Column(nullable=false)
    private Integer stock;

    private String documentationDes;

    @Column(nullable=false)
    private Boolean active;

    @Column(nullable=false)
    private Integer bookingTypeId;

    @Column(nullable=false)
    private Integer originId;

    @Column(nullable=false)
    private Integer destinationId;

    @Column(nullable=false)
    private Integer hotelId;

    @ManyToOne
    @JoinColumn(name = "bookingTypeId", insertable=false, updatable=false)
    private BookingType bookingType;

    @ManyToOne
    @JoinColumn(name = "originId", insertable=false, updatable=false)
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "destinationId", insertable=false, updatable=false)
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "hotelId", insertable=false, updatable=false)
    private Hotel hotel;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Offer> offers;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ProductExcursion> productExcursions;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ProductTransport> productTransports;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Favorite> favorites;

    public Product() {
    }

    public Product(Integer id, Date createdDate, String name, Date departureDate, Date returnDate, Float price, Integer stock, String documentationDes, Boolean active, Integer bookingTypeId, Integer originId, Integer destinationId, Integer hotelId) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.name = name;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
        this.stock = stock;
        this.documentationDes = documentationDes;
        this.active = active;
        this.bookingTypeId = bookingTypeId;
        this.originId = originId;
        this.destinationId = destinationId;
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDocumentationDes() {
        return documentationDes;
    }

    public void setDocumentationDes(String documentationDes) {
        this.documentationDes = documentationDes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getBookingTypeId() {
        return bookingTypeId;
    }

    public void setBookingTypeId(Integer bookingTypeId) {
        this.bookingTypeId = bookingTypeId;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<ProductExcursion> getProductExcursions() {
        return productExcursions;
    }

    public void setProductExcursions(Set<ProductExcursion> productExcursions) {
        this.productExcursions = productExcursions;
    }

    public Set<ProductTransport> getProductTransports() {
        return productTransports;
    }

    public void setProductTransports(Set<ProductTransport> productTransports) {
        this.productTransports = productTransports;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
