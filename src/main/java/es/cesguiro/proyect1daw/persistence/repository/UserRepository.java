package es.cesguiro.proyect1daw.persistence.repository;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Cart getCart();

    Optional<User> findById(int id);
}
