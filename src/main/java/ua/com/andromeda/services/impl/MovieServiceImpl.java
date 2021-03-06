package ua.com.andromeda.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.andromeda.dao.MovieDao;
import ua.com.andromeda.entities.Movie;
import ua.com.andromeda.services.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Transactional
    @Override
    public Movie find(Long id) {
        return movieDao.find(id);
    }

    @Transactional
    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Transactional
    @Override
    public void saveOrUpdate(Movie movie) {
        movieDao.saveOrUpdate(movie);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        movieDao.delete(id);
    }

    @Transactional
    @Override
    public List<Movie> findDistinctMovies() {
        return movieDao.findDistinctMovies();
    }
}
