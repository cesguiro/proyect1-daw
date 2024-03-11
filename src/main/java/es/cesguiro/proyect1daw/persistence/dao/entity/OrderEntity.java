package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    Integer id;
    Integer userId;
    int status;
}
