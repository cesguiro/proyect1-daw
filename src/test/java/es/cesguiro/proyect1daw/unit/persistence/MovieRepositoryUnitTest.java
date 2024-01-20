package es.cesguiro.proyect1daw.unit.persistence;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;
import es.cesguiro.proyect1daw.persistence.repositoryImpl.MovieRepositoryImpl;
import mock.MovieDaoMockImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieRepositoryUnitTest {

    private MovieDao movieDaoMock = new MovieDaoMockImpl();
    private MovieRepository movieRepository = new MovieRepositoryImpl(movieDaoMock);

    @Test
    public void testFindAll() {
        List<Movie> movies = movieRepository.findAll();
        assertEquals(3, movies.size());

        assertEquals("Cadena perpetua", movies.get(0).getTitle());
        System.out.println(movies.get(0));
        assertEquals(1994, movies.get(0).getYear());
        assertEquals(142, movies.get(0).getRuntime());

    }
}
