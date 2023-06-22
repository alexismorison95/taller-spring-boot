package taller.hotel.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import taller.hotel.domain.entities.HotelPhoto;

public interface IHotelPhotoRepository extends JpaRepository<HotelPhoto, Integer> {
}
