package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.OrderDetail;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderDetailEntity;

import java.math.BigDecimal;

public class OrderDetailMapper {

    public static OrderDetail toOrderDetail(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        }
        return new OrderDetail(orderDetailEntity.getId(), orderDetailEntity.getQuantity(), orderDetailEntity.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
