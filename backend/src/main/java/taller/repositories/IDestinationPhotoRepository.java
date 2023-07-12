package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.DestinationPhoto;
import taller.domain.HotelPhoto;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDestinationPhotoRepository extends JpaRepository<DestinationPhoto, Integer> {

    List<DestinationPhoto> findByDestinationId(Integer destinationId);
}
