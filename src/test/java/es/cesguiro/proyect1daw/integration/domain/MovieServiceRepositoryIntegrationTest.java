package es.cesguiro.proyect1daw.integration.domain;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import es.cesguiro.proyect1daw.domain.service.MovieService;
import es.cesguiro.proyect1daw.domain.service.impl.MovieServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;
import es.cesguiro.proyect1daw.persistence.repositoryImpl.MovieRepositoryImpl;
import es.cesguiro.proyect1daw.mock.MovieDaoMockImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceRepositoryIntegrationTest {

    private final MovieDao movieDaoMock = new MovieDaoMockImpl();
    private final MovieRepository movieRepository = new MovieRepositoryImpl(movieDaoMock);
    private final MovieService movieService = new MovieServiceImpl(movieRepository);

    @Test
    public void testFindAll() {
        List<Movie> movies = movieService.findAll();
        assertEquals(3, movies.size());

        assertEquals("Cadena perpetua", movies.get(0).getTitle());
        System.out.println(movies.get(0));
        assertEquals(1994, movies.get(0).getYear());
        assertEquals(142, movies.get(0).getRuntime());

    }
}
