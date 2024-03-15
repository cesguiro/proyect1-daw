package es.cesguiro.proyect1daw.persistence.repository.impl;

import es.cesguiro.proyect1daw.common.container.BookIoc;
import es.cesguiro.proyect1daw.common.container.OrderDetailIoc;
import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.CartDetail;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.OrderDao;
import es.cesguiro.proyect1daw.persistence.dao.OrderDetailDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderDetailEntity;
import es.cesguiro.proyect1daw.persistence.dao.entity.OrderEntity;
import es.cesguiro.proyect1daw.persistence.repository.CartRepository;
import es.cesguiro.proyect1daw.persistence.repository.mapper.BookMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.CartDetailMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.CartMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.OrderMapper;

import java.util.List;
import java.util.Optional;

public class CartRepositoryImpl implements CartRepository {

    private final OrderDao orderDao;

    public CartRepositoryImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Optional<Cart> findByUserId(Integer userId) {
        OrderEntity orderEntity = orderDao.findCartByUserId(userId).orElse(null);
        Cart cart = CartMapper.toCart(orderEntity);

        //recuperamos los detalles del pedido
        OrderDetailDao orderDetailDao = OrderDetailIoc.getOrderDetailDao();
        BookDao bookDao = BookIoc.getBookDao();
        List<CartDetail> cartDetailList = orderDetailDao.findByOrderId(cart.getId())
                .stream()
                .map(
                        orderDetailEntity -> {
                            CartDetail cartDetail = CartDetailMapper.toCartDetail(orderDetailEntity);
                            cartDetail.setBook(
                                    BookMapper.toBook(
                                            bookDao.findById(orderDetailEntity.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"))));
                            return cartDetail;
                        }
                )
                .toList();

        cartDetailList.forEach(cart::addCartDetail);
        return Optional.ofNullable(cart);
    }

    @Override
    public void save(Cart cart) {
        OrderEntity orderEntity = OrderMapper.toOrderEntity(cart);
        List<OrderDetailEntity> orderDetailEntityList = cart.getCartDetailList()
                .stream()
                .map(
                        cartDetail -> {
                            OrderDetailEntity orderDetailEntity = CartDetailMapper.toOrderDetailEntity(cartDetail);
                            orderDetailEntity.setOrderId(cart.getId());
                            return orderDetailEntity;
                        }
                )
                .toList();
        OrderDetailDao orderDetailDao = OrderDetailIoc.getOrderDetailDao();
        //borramos los detalles del pedido
        orderDetailDao.deleteByOrderId(orderEntity.getId());
        //guardamos los detalles del pedido
        orderDetailEntityList.forEach(orderDetailDao::save);
        //Si el carrito cambia de estado, actualizamos el estado del pedido y creamos un nuevo carrito
        /*if (status != 0) {
            orderEntity.setStatus(status);
            orderDao.updateStatus(orderEntity);
            orderEntity = new OrderEntity();
            orderEntity.setUserId(cart.getUser().getId());
            orderEntity.setStatus(0);
            orderDao.save(orderEntity);
        }*/
    }

    @Override
    public void saveAsOrder(Cart cart) {
        OrderEntity orderEntity = OrderMapper.toOrderEntity(cart);
        orderEntity.setStatus(1);
        orderDao.save(orderEntity);
        List<OrderDetailEntity> orderDetailEntityList = cart.getCartDetailList()
                .stream()
                .map(
                        cartDetail -> {
                            OrderDetailEntity orderDetailEntity = CartDetailMapper.toOrderDetailEntity(cartDetail);
                            orderDetailEntity.setOrderId(cart.getId());
                            return orderDetailEntity;
                        }
                )
                .toList();
        OrderDetailDao orderDetailDao = OrderDetailIoc.getOrderDetailDao();
        //borramos los detalles del pedido
        orderDetailDao.deleteByOrderId(orderEntity.getId());
        //guardamos los detalles del pedido
        orderDetailEntityList.forEach(orderDetailDao::save);
    }

    @Override
    public void delete(Cart cart) {
        orderDao.delete(cart.getId());
    }

    @Override
    public void createCart(Integer userId) {
        orderDao.createCart(userId);
    }
}
