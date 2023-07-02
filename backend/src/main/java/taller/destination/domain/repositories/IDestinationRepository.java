package taller.destination.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.destination.domain.entities.Destination;

@Repository
public interface IDestinationRepository extends JpaRepository<Destination, Integer> {
}
