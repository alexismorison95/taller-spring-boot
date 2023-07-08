package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.OrderState;

@Repository
public interface IOrderStateRepository extends JpaRepository<OrderState, Integer> {
}
