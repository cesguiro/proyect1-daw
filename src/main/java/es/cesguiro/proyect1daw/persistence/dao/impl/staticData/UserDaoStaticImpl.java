package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.UserDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public class UserDaoStaticImpl implements UserDao {

    private List<UserEntity> userEntityList = List.of(
            new UserEntity(1, "user1", "user1@user1.com", false, "C/ user1, Mislata, 57900 (Valencia)"),
            new UserEntity(2, "user2", "user2@user2.com", false, "C/ user2, Torrent, 46900 (Valencia)"),
            new UserEntity(3, "admin", "admin@admin.com", true, "C/ admin, Valencia, 54000 (Valencia)")
    );

    @Override
    public Optional<UserEntity> findById(int id) {
        return userEntityList.stream()
                .filter(userEntity -> userEntity.getId() == id)
                .findFirst();
    }

    /*@Override
    public OrderEntity getCart() {
        OrderDao orderDao = CartIoc.getOrderDao();
        User user = User.getUser()
        //return orderDao.getCart();
    }*/
}
