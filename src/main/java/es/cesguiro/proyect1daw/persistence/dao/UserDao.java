package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.UserEntity;

import java.util.Optional;

public interface UserDao {
    Optional<UserEntity> findById(int id);

    //Cart getCart();
}
