package es.cesguiro.proyect1daw.common.factory;

import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import es.cesguiro.proyect1daw.domain.service.MovieService;
import es.cesguiro.proyect1daw.domain.service.impl.MovieServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.MovieDaoImpl;
import es.cesguiro.proyect1daw.persistence.repositoryImpl.MovieRepositoryImpl;
import lombok.Getter;

public class MovieFactory {

    @Getter
    private static MovieService movieService = createMovieService();

    @Getter
    private static MovieRepository movieRepository = createMovieRepository();

    @Getter
    private static MovieDao movieDao = createMovieDao();

    private MovieFactory(){

    }

    private static MovieService createMovieService() {
        if(movieService == null) {
            movieService = new MovieServiceImpl(createMovieRepository());
        }
        return movieService;
    }

    private static MovieRepository createMovieRepository() {
        if(movieRepository == null) {
            movieRepository = new MovieRepositoryImpl(createMovieDao());
        }
        return movieRepository;
    }

    private static MovieDao createMovieDao() {
        if(movieDao == null) {
            movieDao = new MovieDaoImpl();
        }
        return movieDao;
    }
}
