package es.cesguiro.proyect1daw.domain.service;

import es.cesguiro.proyect1daw.domain.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllByUserId(int userId);

    Order findById(Integer id);
}
