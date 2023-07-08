package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.ProductTransport;

@Repository
public interface IProductTransportRepository extends JpaRepository<ProductTransport, Integer> {
}
