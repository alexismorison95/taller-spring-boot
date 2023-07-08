package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
