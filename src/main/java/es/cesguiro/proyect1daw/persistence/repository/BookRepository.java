package es.cesguiro.proyect1daw.persistence.repository;

import es.cesguiro.proyect1daw.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(int id);
}
