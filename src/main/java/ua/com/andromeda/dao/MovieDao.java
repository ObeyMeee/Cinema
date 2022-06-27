package ua.com.andromeda.dao;

import ua.com.andromeda.entities.Movie;

import java.util.List;

public interface MovieDao extends BaseDao<Movie> {
    List<Movie> findDistinctMovies();
}
