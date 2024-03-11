package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.domain.service.OrderService;
import es.cesguiro.proyect1daw.domain.service.impl.OrderServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.OrderDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.OrderDaoStaticImpl;
import es.cesguiro.proyect1daw.persistence.repository.OrderRepository;
import es.cesguiro.proyect1daw.persistence.repository.impl.OrderRepositoryImpl;

public class OrderIoc {

    public static OrderService orderService;
    public static OrderRepository orderRepository;
    public static OrderDao orderDao;

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getOrderRepository());
        }
        return orderService;
    }

    private static OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl(getOrderDao());
        }
        return orderRepository;
    }

    private static OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoStaticImpl();
        }
        return orderDao;
    }


}
