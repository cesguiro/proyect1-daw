package es.cesguiro.proyect1daw.controller;

import es.cesguiro.proyect1daw.common.container.OrderIoc;
import es.cesguiro.proyect1daw.domain.entity.Order;
import es.cesguiro.proyect1daw.domain.entity.User;
import es.cesguiro.proyect1daw.domain.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(OrderController.URL)
public class OrderController {

    public final static String URL = "/orders";

    private final OrderService orderService;

    public OrderController() {
        this.orderService = OrderIoc.getOrderService();
    }

    @RequestMapping
    public String findAllByUser(Model model) {
        int userId = User.USER_ID; //Simulamos que el usuario está logueado y leemos el usuario de la sesión
        List<Order> orderList = orderService.findAllByUserId(userId);
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    @RequestMapping("/{id}")
    public String findById(Model model, @PathVariable Integer id) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "orderDetail.html";
    }
}
