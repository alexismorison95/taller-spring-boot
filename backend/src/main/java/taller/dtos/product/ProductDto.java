package taller.dtos.product;

import org.springframework.stereotype.Component;
import taller.domain.Origin;
import taller.dtos.bookingType.BookingTypeDto;
import taller.dtos.destination.DestinationDto;
import taller.dtos.hotel.HotelDto;

import java.util.Date;

@Component
public class ProductDto {

    private String name;

    private Date departureDate;

    private Date returnDate;

    private Float price;

    private Integer stock;

    private String documentationDes;

    private Boolean active;

    private BookingTypeDto bookingType;

    // TODO: Generate OriginDto
    private Origin origin;

    private HotelDto hotel;

    private DestinationDto destination;



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

    public BookingTypeDto getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingTypeDto bookingType) {
        this.bookingType = bookingType;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }

    public DestinationDto getDestination() {
        return destination;
    }

    public void setDestination(DestinationDto destination) {
        this.destination = destination;
    }
}
