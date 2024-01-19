package es.cesguiro.proyect1daw.domain.entity;

import lombok.Data;

@Data //incluye @Getter, @Setter, @ToString, @EqualsAndHashCode, @NoArgsConstructor y @AllArgsConstructor
public class Movie {

    private Integer id;
    private String title;
    private int year;
    private int runtime;
}
