package es.cesguiro.proyect1daw.persistence.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Integer id;
    private String userName;
    private String email;
    private boolean admin;
    private String deliveryAddress;
}
