package ua.com.andromeda.services;

import ua.com.andromeda.entities.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie>{
    List<Movie> findDistinctMovies();
}
