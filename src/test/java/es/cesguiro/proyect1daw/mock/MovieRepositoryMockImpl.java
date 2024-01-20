package es.cesguiro.proyect1daw.mock;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;

import java.util.List;

public class MovieRepositoryMockImpl implements MovieRepository {

    List<Movie> movieList = List.of(
            new Movie(1, "Cadena perpetua", 1994, 142),
            new Movie(2, "El padrino", 1972, 175),
            new Movie(3, "El caballero oscuro", 2008, 152)
    );

    @Override
    public List<Movie> findAll() {
        return movieList;
    }
}
