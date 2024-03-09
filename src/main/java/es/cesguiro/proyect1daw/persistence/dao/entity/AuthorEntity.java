package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    private Integer id;
    private String name;

    public AuthorEntity(String name) {
        this.name = name;
    }
}
