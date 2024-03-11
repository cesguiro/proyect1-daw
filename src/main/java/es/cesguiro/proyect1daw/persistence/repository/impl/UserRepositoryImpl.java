package es.cesguiro.proyect1daw.persistence.repository.impl;

import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.persistence.dao.UserDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.UserEntity;
import es.cesguiro.proyect1daw.persistence.repository.UserRepository;
import es.cesguiro.proyect1daw.persistence.repository.mapper.UserMapper;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Cart getCart() {
        //userDao.getCart();
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        UserEntity userEntity  = userDao.findById(id).orElse(null);
        if(userEntity == null) return Optional.empty();
        return Optional.of(UserMapper.toUser(userEntity));
    }
}
