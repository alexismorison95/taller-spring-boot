package taller.hotel.domain.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.hotel.domain.entities.Hotel;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByDestinationId(Integer destinationId);
}
