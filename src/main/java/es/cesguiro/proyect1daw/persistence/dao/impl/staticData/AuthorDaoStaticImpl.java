package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.AuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public class AuthorDaoStaticImpl implements AuthorDao {

    private List<AuthorEntity> authorEntityList = List.of(
            new AuthorEntity(1, "John Kennedy Toole"),
            new AuthorEntity(2, "Umberto Eco"),
            new AuthorEntity(3, "Milan Kundera"),
            new AuthorEntity(4, "Terry Pratchett"),
            new AuthorEntity(5, "Neil Gaiman")

    );

    @Override
    public Optional<AuthorEntity> findById(Integer authorId) {
        return authorEntityList.stream()
                .filter(authorEntity -> authorEntity.getId().equals(authorId))
                .findFirst();
    }
}
