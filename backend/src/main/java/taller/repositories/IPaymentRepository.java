package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
