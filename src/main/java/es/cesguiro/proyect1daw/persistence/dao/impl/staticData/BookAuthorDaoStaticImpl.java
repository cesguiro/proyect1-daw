package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.common.container.AuthorIoc;
import es.cesguiro.proyect1daw.persistence.dao.AuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.BookAuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;
import es.cesguiro.proyect1daw.persistence.dao.entity.BookAuthorEntity;

import java.util.List;

public class BookAuthorDaoStaticImpl implements BookAuthorDao {

    List<BookAuthorEntity> bookAuthorEntityList = List.of(
            new BookAuthorEntity(1, 1, 1),
            new BookAuthorEntity(2, 2, 2),
            new BookAuthorEntity(3, 3, 3),
            new BookAuthorEntity(4, 4, 2),
            new BookAuthorEntity(5, 5, 4),
            new BookAuthorEntity(6, 5, 5)
    );

    @Override
    public List<AuthorEntity> findByBookId(Integer id) {
        AuthorDao authorDao = AuthorIoc.getAuthorDao();
        return bookAuthorEntityList.stream()
                .filter(bookAuthorEntity -> bookAuthorEntity.getBookId() == id)
                .map(bookAuthorEntity -> authorDao.findById(bookAuthorEntity.getAuthorId()).orElse(null))
                .toList();
    }
}
