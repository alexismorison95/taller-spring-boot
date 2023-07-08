package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
