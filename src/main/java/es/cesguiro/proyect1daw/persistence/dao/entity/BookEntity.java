package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    private Integer id;
    private String isbn;
    private String title;
    private String synopsis;
    private BigDecimal price;
    private String cover;
    private int publisherId;

    public BookEntity(String isbn, String title, String synopsis, BigDecimal price, String cover, int publisherId) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.cover = cover;
        this.publisherId = publisherId;
    }
}
