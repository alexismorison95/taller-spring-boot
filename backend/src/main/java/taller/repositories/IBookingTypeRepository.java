package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.BookingType;

@Repository
public interface IBookingTypeRepository extends JpaRepository<BookingType, Integer> {

}
