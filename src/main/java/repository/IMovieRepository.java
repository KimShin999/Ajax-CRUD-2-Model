package repository;

import model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    Iterable<Movie> findByNameContaining(String name);
}
