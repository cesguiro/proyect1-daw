package es.cesguiro.proyect1daw.domain.entity;

import es.cesguiro.proyect1daw.common.container.BookIoc;
import es.cesguiro.proyect1daw.persistence.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetail {

    private Integer id;
    private Book book;
    private Integer quantity;
    private BigDecimal price;

    public CartDetail(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public CartDetail(int id, int quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public void setBook(Book book) {
        this.book = book;
        this.setPrice(book.getPrice());
    }
}
