package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.domain.service.CartService;
import es.cesguiro.proyect1daw.domain.service.impl.CartServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.OrderDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.OrderDaoStaticImpl;
import es.cesguiro.proyect1daw.persistence.repository.CartRepository;
import es.cesguiro.proyect1daw.persistence.repository.impl.CartRepositoryImpl;

public class CartIoc {

    private static CartService cartService;
    private static CartRepository cartRepository;
    private static OrderDao orderDao;

    public static CartService getCartService() {
        if (cartService == null) {
            cartService = new CartServiceImpl(getCartRepository());
        }
        return cartService;
    }

    public static CartRepository getCartRepository() {
        if (cartRepository == null) {
            cartRepository = new CartRepositoryImpl(getOrderDao());
        }
        return cartRepository;
    }

    public static OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoStaticImpl();
        }
        return orderDao;
    }
}
