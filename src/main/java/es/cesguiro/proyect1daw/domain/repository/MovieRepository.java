package es.cesguiro.proyect1daw.domain.repository;

import es.cesguiro.proyect1daw.domain.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
}
