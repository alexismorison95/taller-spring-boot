package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
