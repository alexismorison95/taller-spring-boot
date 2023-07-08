package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Origin;

@Repository
public interface IOriginRepository extends JpaRepository<Origin, Integer> {
}
