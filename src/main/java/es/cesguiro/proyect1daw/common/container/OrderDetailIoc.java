package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.persistence.dao.OrderDetailDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.OrderDetailDaoStaticImpl;

public class OrderDetailIoc {

    public static OrderDetailDao orderDetailDao;

    public static OrderDetailDao getOrderDetailDao() {
        if (orderDetailDao == null) {
            orderDetailDao = new OrderDetailDaoStaticImpl();
        }
        return orderDetailDao;
    }
}
