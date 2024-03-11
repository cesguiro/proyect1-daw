package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.Order;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;

public class OrderMapper {
    public static Order toOrder(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return new Order(
                orderEntity.getId()
        );
    }

    public static OrderEntity toOrderEntity(Cart cart) {
        if (cart == null) {
            return null;
        }
        return new OrderEntity(
                cart.getId(),
                cart.getUser().getId(),
                0
        );
    }
}
