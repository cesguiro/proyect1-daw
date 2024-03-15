package es.cesguiro.proyect1daw.domain.service.impl;

import es.cesguiro.proyect1daw.common.container.BookIoc;
import es.cesguiro.proyect1daw.common.container.OrderIoc;
import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.CartDetail;
import es.cesguiro.proyect1daw.domain.service.CartService;
import es.cesguiro.proyect1daw.persistence.repository.BookRepository;
import es.cesguiro.proyect1daw.persistence.repository.CartRepository;
import es.cesguiro.proyect1daw.persistence.repository.OrderRepository;

import java.util.concurrent.atomic.AtomicBoolean;

public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart findByUserId(int userId) {
        return cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public void addCartDetail(Cart cart, CartDetail cartDetail) {
        /*Book book = cart.getCartDetailList().stream()
                .filter(existingCartDetail -> existingCartDetail.getBook().getId().equals(cartDetail.getBook().getId()))
                .map(CartDetail::getBook)
                .findFirst()
                .orElse(null);
        if (book == null) {
            BookRepository bookRepository = BookIoc.getBookRepository();
            book = bookRepository.findById(cartDetail.getBook().getId()).orElseThrow(() -> new RuntimeException("Book not found"));
            cartDetail.setBook(book);
            cartDetail.setPrice(book.getPrice());
            cart.addCartDetail(cartDetail);
        } else {
            cart.getCartDetailList().forEach(
                    existingCartDetail -> {
                        if (existingCartDetail.getBook().getId().equals(cartDetail.getBook().getId())) {
                            existingCartDetail.setQuantity(existingCartDetail.getQuantity() + cartDetail.getQuantity());
                        }
                    }
            );
        }*/
        AtomicBoolean bookExists = new AtomicBoolean(false);
        cart.getCartDetailList().forEach(
                existingCartDetail -> {
                    if (existingCartDetail.getBook().getId().equals(cartDetail.getBook().getId())) {
                        existingCartDetail.setQuantity(existingCartDetail.getQuantity() + cartDetail.getQuantity());
                        bookExists.set(true);
                    }
                }
        );
        if (!bookExists.get()) {
            addBookToCartDetail(cartDetail, cartDetail.getBook().getId());
            cart.addCartDetail(cartDetail);
        }
        cartRepository.save(cart);
    }

    @Override
    public void saveAsOrder(Cart cart) {
        cart.getCartDetailList().forEach(
                cartDetail -> addBookToCartDetail(cartDetail, cartDetail.getBook().getId())
        );

        //guardar el carrito como pedido
        cartRepository.saveAsOrder(cart);
        //crear un nuevo carrito para el usuario
        cartRepository.createCart(cart.getUser().getId());
    }

    private void addBookToCartDetail(CartDetail cartDetail, int bookId) {
        BookRepository bookRepository = BookIoc.getBookRepository();
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        cartDetail.setBook(book);
    }
}
