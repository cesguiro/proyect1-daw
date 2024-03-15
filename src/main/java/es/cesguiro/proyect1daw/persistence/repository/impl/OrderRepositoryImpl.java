package es.cesguiro.proyect1daw.persistence.repository.impl;

import es.cesguiro.proyect1daw.common.container.BookIoc;
import es.cesguiro.proyect1daw.common.container.OrderDetailIoc;
import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.Order;
import es.cesguiro.proyect1daw.domain.entity.OrderDetail;
import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.OrderDao;
import es.cesguiro.proyect1daw.persistence.dao.OrderDetailDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;
import es.cesguiro.proyect1daw.persistence.repository.OrderRepository;
import es.cesguiro.proyect1daw.persistence.repository.mapper.BookMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.OrderDetailMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.OrderMapper;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final OrderDao orderDao;

    public OrderRepositoryImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> findAllByUser(User user) {
        List<OrderEntity> orderEntityList = orderDao.findAllByUserId(user.getId());
        List<Order> orderList = orderEntityList.stream().map(OrderMapper::toOrder).toList();

        //recuperamos los detalles del pedido para calcular el total del pedido
        OrderDetailDao orderDetailDao = OrderDetailIoc.getOrderDetailDao();
        orderList.forEach(order -> {
                    orderDetailDao.findByOrderId(order.getId())
                            .stream()
                            .map(OrderDetailMapper::toOrderDetail)
                            .forEach(order::addOrderDetail);
        });
        return orderList;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        OrderEntity orderEntity = orderDao.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        Order order = OrderMapper.toOrder(orderEntity);

        //recuperamos los detalles del pedido
        OrderDetailDao orderDetailDao = OrderDetailIoc.getOrderDetailDao();
        BookDao bookDao = BookIoc.getBookDao();
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(order.getId())
                .stream()
                .map(
                        orderDetailEntity -> {
                            OrderDetail orderDetail = OrderDetailMapper.toOrderDetail(orderDetailEntity);
                            orderDetail.setBook(
                                    BookMapper.toBook(
                                            bookDao.findById(orderDetailEntity.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"))));
                            return orderDetail;
                        }
                )
                .toList();
        orderDetailList.forEach(order::addOrderDetail);

        return Optional.of(order);
    }

}
