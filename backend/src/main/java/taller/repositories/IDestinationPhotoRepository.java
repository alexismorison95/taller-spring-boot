package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.DestinationPhoto;

@Repository
public interface IDestinationPhotoRepository extends JpaRepository<DestinationPhoto, Integer> {
}
