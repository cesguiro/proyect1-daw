package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailEntity {

    Integer id;
    Integer orderId;
    int bookId;
    int quantity;
    BigDecimal price;

    public OrderDetailEntity(int bookId, int quantity, BigDecimal price) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }
}
