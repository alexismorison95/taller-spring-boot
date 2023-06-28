package taller.bookingType.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingTypeRepository extends JpaRepository<BookingType, Integer> {

}
