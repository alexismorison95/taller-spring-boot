package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Transport;

@Repository
public interface ITransportRepository extends JpaRepository<Transport, Integer> {
}
