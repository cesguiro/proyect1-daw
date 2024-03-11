package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    Optional<OrderEntity> findCartByUserId(Integer id);

    List<OrderEntity> findAllByUserId(Integer id);

    Optional<OrderEntity> findById(Integer id);

    void save(OrderEntity orderEntity);

    void updateStatus(OrderEntity orderEntity);
}
