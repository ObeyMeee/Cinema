package ua.com.andromeda.service;

import ua.com.andromeda.entities.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie>{
    List<Movie> findDistinctMovies();
}
