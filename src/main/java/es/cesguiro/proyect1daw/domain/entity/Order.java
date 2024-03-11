package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private User user;
    private List<OrderDetail> orderDetailList;
    private BigDecimal total = BigDecimal.ZERO;

    public Order(Integer id) {
        this.id = id;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if(this.orderDetailList == null) {
            this.orderDetailList = new ArrayList<>();
        }
        this.orderDetailList.add(orderDetail);
        this.total = this.total.add(orderDetail.getTotal());
    }
}
