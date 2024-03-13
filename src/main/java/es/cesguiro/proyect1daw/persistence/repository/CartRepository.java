package es.cesguiro.proyect1daw.persistence.repository;

import es.cesguiro.proyect1daw.domain.entity.Cart;

import java.util.Optional;

public interface CartRepository {

    Optional<Cart> findByUserId(Integer userId);

    void save(Cart cart);

    void saveAsOrder(Cart cart);

    void delete(Cart cart);

    void createCart(Integer id);
}
