package es.cesguiro.proyect1daw.domain.service;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.CartDetail;

public interface CartService {

    Cart findByUserId(int userId);

    void addCartDetail(Cart cart, CartDetail cartDetail);

    void saveAsOrder(Cart cart);
}
