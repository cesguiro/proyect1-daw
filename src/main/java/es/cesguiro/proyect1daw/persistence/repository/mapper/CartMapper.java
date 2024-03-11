package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;

public class CartMapper {
    public static Cart toCart(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return new Cart(orderEntity.getId());
    }

}
