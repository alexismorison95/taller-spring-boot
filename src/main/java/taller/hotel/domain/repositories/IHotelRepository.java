package taller.hotel.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import taller.hotel.domain.entities.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
}
