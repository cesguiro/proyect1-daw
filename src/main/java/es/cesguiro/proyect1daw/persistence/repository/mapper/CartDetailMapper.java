package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.CartDetail;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderDetailEntity;

public class CartDetailMapper {

    public static CartDetail toCartDetail(OrderDetailEntity orderDetailEntity) {
        if (orderDetailEntity == null) {
            return null;
        }
        return new CartDetail(
                orderDetailEntity.getId(),
                orderDetailEntity.getQuantity(),
                orderDetailEntity.getPrice()
        );
    }

    public static OrderDetailEntity toOrderDetailEntity(CartDetail cartDetail) {
        if (cartDetail == null) {
            return null;
        }
        return new OrderDetailEntity(
                cartDetail.getBook().getId(),
                cartDetail.getQuantity(),
                cartDetail.getPrice()
        );
    }
}
