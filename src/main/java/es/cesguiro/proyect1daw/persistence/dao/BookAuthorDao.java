package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;

import java.util.List;

public interface BookAuthorDao {
    List<AuthorEntity> findByBookId(Integer id);
}
