package es.cesguiro.proyect1daw.persistence.repository;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.Order;
import es.cesguiro.proyect1daw.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> findAllByUser(User user);

    Optional<Order> findById(Integer id);

    void save(Cart cart);
}
