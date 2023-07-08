package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Offer;

@Repository
public interface IOfferRepository extends JpaRepository<Offer, Integer> {
}
