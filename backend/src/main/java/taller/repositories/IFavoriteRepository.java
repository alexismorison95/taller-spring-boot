package taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.domain.Favorite;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Integer> {
}
