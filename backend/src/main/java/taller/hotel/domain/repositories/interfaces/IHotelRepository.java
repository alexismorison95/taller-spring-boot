package taller.hotel.domain.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.hotel.domain.entities.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
}
