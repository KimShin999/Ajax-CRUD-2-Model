package service.movie;

import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IMovieRepository;

public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    public void update(Movie model) {
        movieRepository.save(model);
    }

    @Override
    public void save(Movie model) {
        movieRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        movieRepository.delete(id);
    }

    @Override
    public Iterable<Movie> findAllByNameContaining(String name) {
        return movieRepository.findByNameContaining(name);
    }
}
