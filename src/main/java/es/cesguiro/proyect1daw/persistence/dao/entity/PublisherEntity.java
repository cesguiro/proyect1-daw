package es.cesguiro.proyect1daw.persistence.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherEntity {
    private Integer id;
    private String name;

    public PublisherEntity(String name) {
        this.name = name;
    }
}
