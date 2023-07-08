package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.RegistrationMethod;

@Repository
public interface IRegistrationMethodRepository extends JpaRepository<RegistrationMethod, Integer> {
}
