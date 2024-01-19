package es.cesguiro.proyect1daw.unit.persistence;

import es.cesguiro.proyect1daw.common.factory.MovieFactory;
import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieDaoUnitTest {

    private static MovieDao movieDao;
    @BeforeAll
    public static void init(){
        movieDao = MovieFactory.getMovieDao();
    }

    @Test
    public void testFindAll() {
        List<Movie> movies = movieDao.findAll();
        assertEquals(3, movies.size()); // Ajusta el número según la cantidad de películas en tu script SQL

        // Puedes agregar más aserciones para verificar los detalles de las películas si es necesario
        assertEquals("Cadena perpetua", movies.get(0).getTitle());
        System.out.println(movies.get(0));
        assertEquals(1994, movies.get(0).getYear());
        assertEquals(142, movies.get(0).getRuntime());

        // Repite las aserciones para las otras películas
        // ...

    }

}
