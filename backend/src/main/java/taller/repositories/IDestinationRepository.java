package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Destination;

@Repository
public interface IDestinationRepository extends JpaRepository<Destination, Integer> {
}
