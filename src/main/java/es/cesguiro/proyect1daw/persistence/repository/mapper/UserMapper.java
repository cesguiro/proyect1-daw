package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.persistence.dao.entity.UserEntity;

import java.util.Optional;

public class UserMapper {
    public static User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUserName(), userEntity.getEmail(), userEntity.isAdmin(), userEntity.getDeliveryAddress());
    }
}
