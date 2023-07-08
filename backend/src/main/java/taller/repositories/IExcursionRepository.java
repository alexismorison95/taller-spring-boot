package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Excursion;

@Repository
public interface IExcursionRepository extends JpaRepository<Excursion, Integer> {
}
