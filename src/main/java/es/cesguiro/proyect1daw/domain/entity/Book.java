package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.math.BigDecimal;
import java.util.List;

@Data //incluye @Getter, @Setter, @ToString y @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private String synopsis;
    private BigDecimal price;
    private String cover;
    private Publisher publisher;
    @Singular
    List<Author> authorList;

    public Book(Integer id, String isbn, String title, String synopsis, BigDecimal price, String cover) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.cover = cover;
    }
}
