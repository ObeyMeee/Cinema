package ua.com.andromeda.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.andromeda.dao.MovieDao;
import ua.com.andromeda.entities.Movie;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public MovieDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie find(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Movie.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Movie> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Movie").list();

    }

    @Override
    public void saveOrUpdate(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(movie);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Movie deletedMovie = find(id);
        session.delete(deletedMovie);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Movie> findDistinctMovies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Movie group by name").list();
    }
}
