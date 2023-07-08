package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
