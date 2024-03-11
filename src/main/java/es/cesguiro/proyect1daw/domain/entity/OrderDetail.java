package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private Integer id;
    private Book book;
    private Integer quantity;
    private BigDecimal price;

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public OrderDetail(Integer id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}
