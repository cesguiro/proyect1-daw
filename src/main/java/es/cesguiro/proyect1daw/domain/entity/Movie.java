package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //incluye @Getter, @Setter, @ToString y @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Integer id;
    private String title;
    private int year;
    private int runtime;
}
