package es.cesguiro.proyect1daw.persistence.repositoryImpl;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDao movieDao;

    public MovieRepositoryImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }
}
