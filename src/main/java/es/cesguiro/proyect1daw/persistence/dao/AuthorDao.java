package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;

import java.util.Optional;

public interface AuthorDao {
    Optional<AuthorEntity> findById(Integer authorId);
}
