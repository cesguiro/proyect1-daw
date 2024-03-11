package es.cesguiro.proyect1daw.domain.service.impl;

import es.cesguiro.proyect1daw.common.container.UserIoc;
import es.cesguiro.proyect1daw.domain.entity.Order;
import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.domain.service.OrderService;
import es.cesguiro.proyect1daw.persistence.repository.OrderRepository;
import es.cesguiro.proyect1daw.persistence.repository.UserRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllByUserId(int userId) {
        UserRepository userRepository = UserIoc.getUserRepository();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
