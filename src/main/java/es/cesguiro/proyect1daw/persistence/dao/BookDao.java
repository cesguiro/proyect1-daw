package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(int id);
}
