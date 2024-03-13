package es.cesguiro.proyect1daw.controller;

import es.cesguiro.proyect1daw.common.container.CartIoc;
import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.domain.entity.Cart;
import es.cesguiro.proyect1daw.domain.entity.CartDetail;
import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.domain.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(CartController.URL)
public class CartController {

    public static final String URL = "/carts";
    private final CartService cartService;

    public CartController() {
        this.cartService = CartIoc.getCartService();
    }

    @PostMapping("/books/{bookId}")
    public String addBook(@PathVariable int bookId, @RequestParam int quantity) {
        int userId = User.USER_ID; //Simulamos que el usuario está logueado y leemos el usuario de la sesión
        Cart cart = cartService.findByUserId(userId);
        cart.setUser(new User(userId));
        Book book = new Book(bookId);
        CartDetail cartDetail = new CartDetail(book, quantity);
        cartService.addCartDetail(cart, cartDetail);
        return "redirect:/carts";
    }

    @GetMapping
    public String findActiveCart(Model model) {
        int userId = User.USER_ID; //Simulamos que el usuario está logueado y leemos el usuario de la sesión
        Cart cart = cartService.findByUserId(userId);
        model.addAttribute("cart", cart);
        return "cartDetail";
    }

    @PutMapping
    public String saveAsOrder(@ModelAttribute Cart cart) {
        //System.out.println(cart);
        int userId = User.USER_ID; //Simulamos que el usuario está logueado y leemos el usuario de la sesión
        cart.setUser(new User(userId));
        cartService.saveAsOrder(cart);
        return "redirect:/orders";
    }


}
