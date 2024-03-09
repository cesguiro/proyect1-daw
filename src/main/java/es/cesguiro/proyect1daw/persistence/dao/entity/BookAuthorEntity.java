package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorEntity {

    private Integer id;
    private Integer bookId;
    private Integer authorId;

    public BookAuthorEntity(Integer bookId, Integer authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }
}
