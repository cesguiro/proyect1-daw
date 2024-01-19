package es.cesguiro.proyect1daw.controller;

import es.cesguiro.proyect1daw.common.factory.MovieFactory;
import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.domain.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(MovieController.URL)
public class MovieController {

    public static final String URL = "/movies";
    private final MovieService movieService;

    public MovieController() {
        this.movieService = MovieFactory.getMovieService();
    }

    @GetMapping()
    public String findAll(){
        List<Movie> movieList = movieService.findAll();
        System.out.println(movieList.get(0));
        return "movies";
    }
}
