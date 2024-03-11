package es.cesguiro.proyect1daw.persistence.repository;

import es.cesguiro.proyect1daw.domain.entity.Cart;

import java.util.Optional;

public interface CartRepository {

    Optional<Cart> findByUserId(Integer userId);

    void save(Cart cart, int satus);
}
