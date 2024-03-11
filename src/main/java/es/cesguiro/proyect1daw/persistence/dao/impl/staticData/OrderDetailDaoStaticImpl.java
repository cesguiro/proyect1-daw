package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.OrderDetailDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderDetailEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoStaticImpl implements OrderDetailDao {

    List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();

    public OrderDetailDaoStaticImpl(){
        orderDetailEntityList.add(new OrderDetailEntity(1, 3, 3, 1, new BigDecimal(11.50)));
        orderDetailEntityList.add(new OrderDetailEntity(2, 3, 1, 2, new BigDecimal(13.20)));
        orderDetailEntityList.add(new OrderDetailEntity(3, 3, 5, 1, new BigDecimal(9.30)));
        orderDetailEntityList.add(new OrderDetailEntity(4, 4, 6, 4, new BigDecimal(10.40)));
        orderDetailEntityList.add(new OrderDetailEntity(5, 5, 1, 1, new BigDecimal(11.20)));
    }

    @Override
    public List<OrderDetailEntity> findByOrderId(Integer orderId) {
        return orderDetailEntityList
                .stream()
                .filter(orderDetailEntity -> orderDetailEntity.getOrderId().equals(orderId))
                .toList();
    }

    @Override
    public void deleteByOrderId(Integer orderId) {
        orderDetailEntityList.removeIf(orderDetailEntity -> orderDetailEntity.getOrderId().equals(orderId));
    }

    @Override
    public void save(OrderDetailEntity orderDetailEntity) {
        orderDetailEntityList.add(new OrderDetailEntity(
                orderDetailEntityList.size() + 1,
                orderDetailEntity.getOrderId(),
                orderDetailEntity.getBookId(),
                orderDetailEntity.getQuantity(),
                orderDetailEntity.getPrice()
        ));
    }
}
