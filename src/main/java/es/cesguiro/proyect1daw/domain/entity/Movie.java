package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //incluye @Getter, @Setter, @ToString, @EqualsAndHashCode y @NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Integer id;
    private String title;
    private int year;
    private int runtime;
}
