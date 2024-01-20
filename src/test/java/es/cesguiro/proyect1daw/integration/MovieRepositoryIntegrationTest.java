package es.cesguiro.proyect1daw.integration;

import es.cesguiro.proyect1daw.common.factory.MovieFactory;
import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.repository.MovieRepository;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieRepositoryIntegrationTest {

    private final MovieRepository movieRepository = MovieFactory.getMovieRepository();

    @BeforeEach
    public void beforeEach(){
        // Configuración de Flyway
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:testdb", "sa", "sa").load();

        // Ejecución de migraciones
        flyway.migrate();

        // Verificar que las migraciones se hayan ejecutado correctamente
        for (MigrationInfo migrationInfo : flyway.info().all()) {
            System.out.println("Migración ejecutada: " + migrationInfo.getDescription());
        }

    }
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
