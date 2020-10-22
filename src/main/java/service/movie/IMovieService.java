package service.movie;

import model.Movie;
import service.IService;

public interface IMovieService extends IService<Movie> {
    Iterable<Movie> findAllByNameContaining(String name);

}
