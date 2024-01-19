package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.domain.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
}
