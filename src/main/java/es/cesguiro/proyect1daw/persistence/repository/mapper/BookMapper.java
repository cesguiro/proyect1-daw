package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.persistence.dao.entity.BookEntity;

public class BookMapper {

    public static Book toBook(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getSynopsis(),
                bookEntity.getPrice(),
                bookEntity.getCover()
        );
    }
}
