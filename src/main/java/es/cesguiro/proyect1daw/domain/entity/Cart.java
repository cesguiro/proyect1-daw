package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Integer id;
    private User user;
    private List<CartDetail> cartDetailList;
    private BigDecimal total = BigDecimal.ZERO;

    public Cart(Integer id) {
        this.id = id;
    }

    public void addCartDetail(CartDetail cartDetail) {
        if (cartDetailList == null) {
            cartDetailList = new ArrayList<>();
        }
        cartDetailList.add(cartDetail);
        total = total.add(cartDetail.getTotal());
    }

    public List<CartDetail> getCartDetailList() {
        if (cartDetailList == null) {
            cartDetailList = new ArrayList<>();
        }
        return cartDetailList;
    }
}
