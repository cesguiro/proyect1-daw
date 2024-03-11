package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.Author;
import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;

public class AuthorMapper {

    public static Author toAuthor(AuthorEntity authorEntity) {
        return new Author(authorEntity.getId(), authorEntity.getName());
    }
}
