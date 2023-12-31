package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.HotelPhoto;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHotelPhotoRepository extends JpaRepository<HotelPhoto, Integer> {

    Optional<List<HotelPhoto>> findByHotelId(Integer hotelId);
}
