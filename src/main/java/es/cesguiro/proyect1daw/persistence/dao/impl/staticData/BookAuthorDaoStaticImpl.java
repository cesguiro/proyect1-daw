package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.entity.BookAuthorEntity;

import java.util.List;

public class BookAuthorDaoStaticImpl {

    List<BookAuthorEntity> bookAuthorEntityList = List.of(
            new BookAuthorEntity(1, 1, 1),
            new BookAuthorEntity(2, 2, 2),
            new BookAuthorEntity(3, 3, 3),
            new BookAuthorEntity(4, 4, 2),
            new BookAuthorEntity(5, 5, 4),
            new BookAuthorEntity(6, 5, 5)
    );
}
