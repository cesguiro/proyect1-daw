package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.persistence.dao.UserDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.UserDaoStaticImpl;
import es.cesguiro.proyect1daw.persistence.repository.UserRepository;
import es.cesguiro.proyect1daw.persistence.repository.impl.UserRepositoryImpl;

public class UserIoc {

    private static UserRepository userRepository;
    private static UserDao userDao;

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(getUserDao());
        }
        return userRepository;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoStaticImpl();
        }
        return userDao;
    }
}
