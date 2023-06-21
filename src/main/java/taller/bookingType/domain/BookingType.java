package taller.bookingType.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "BookingType")
public class BookingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookingTypeId;

    private String Name;

    public BookingType() {
    }

    public BookingType(Integer bookingTypeId, String name) {
        BookingTypeId = bookingTypeId;
        Name = name;
    }

    public Integer getBookingTypeId() {
        return BookingTypeId;
    }

    public void setBookingTypeId(Integer bookingTypeId) {
        BookingTypeId = bookingTypeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
