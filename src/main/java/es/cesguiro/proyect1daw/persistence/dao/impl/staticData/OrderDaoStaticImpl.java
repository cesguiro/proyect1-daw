package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.OrderDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoStaticImpl implements OrderDao {

    static List<OrderEntity> orderEntityList = new ArrayList<>();

    public OrderDaoStaticImpl() {
        orderEntityList.add(new OrderEntity(1, 1, 0));
        orderEntityList.add(new OrderEntity(2, 2, 0));
        orderEntityList.add(new OrderEntity(3, 1, 1));
        orderEntityList.add(new OrderEntity(4, 1, 1));
        orderEntityList.add(new OrderEntity(5, 1, 1));
    }

    @Override
    public Optional<OrderEntity> findCartByUserId(Integer id) {
        return orderEntityList
                .stream()
                .filter(orderEntity -> orderEntity.getUserId().equals(id) && orderEntity.getStatus() == 0)
                .findFirst();
    }

    @Override
    public List<OrderEntity> findAllByUserId(Integer id) {
        return orderEntityList
                .stream()
                .filter(orderEntity -> orderEntity.getUserId().equals(id) && orderEntity.getStatus() != 0)
                .toList();
    }

    @Override
    public Optional<OrderEntity> findById(Integer id) {
        return orderEntityList
                .stream()
                .filter(orderEntity -> orderEntity.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(OrderEntity orderEntity) {
        orderEntityList.add(orderEntity);
    }

    @Override
    public void updateStatus(OrderEntity orderEntity) {
        orderEntityList
                .stream()
                .filter(entity -> entity.getId().equals(orderEntity.getId()))
                .findFirst()
                .ifPresent(entity -> entity.setStatus(orderEntity.getStatus()));
    }

    @Override
    public void delete(Integer id) {
        orderEntityList.removeIf(orderEntity -> orderEntity.getId().equals(id));
    }

    @Override
    public void createCart(Integer userId) {
        int id = orderEntityList.stream().map(OrderEntity::getId).max(Integer::compareTo).orElse(0) + 1;
        orderEntityList.add(new OrderEntity(id, userId, 0));
    }

}
