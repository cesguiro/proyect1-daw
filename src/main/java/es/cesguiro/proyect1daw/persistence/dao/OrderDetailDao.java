package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.OrderDetailEntity;

import java.util.List;

public interface OrderDetailDao {
    List<OrderDetailEntity> findByOrderId(Integer orderId);

    void deleteByOrderId(Integer orderId);

    void save(OrderDetailEntity orderDetailEntity);
}
