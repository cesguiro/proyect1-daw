package es.cesguiro.proyect1daw.domain.service.impl;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import es.cesguiro.proyect1daw.domain.service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
