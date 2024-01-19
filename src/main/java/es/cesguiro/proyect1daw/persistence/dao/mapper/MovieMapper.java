package es.cesguiro.proyect1daw.persistence.dao.mapper;

import es.cesguiro.proyect1daw.domain.entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public Movie toMovie(ResultSet resultSet) {
        if(resultSet ==  null) {
            return null;
        }
        Movie movie = new Movie();

        try {
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setRuntime(resultSet.getInt("runtime"));
            movie.setYear(resultSet.getInt("year"));
        } catch (SQLException e) {
            throw new RuntimeException("Algo no ha funcionado: " + e.getMessage());
        }
        return movie;
    }

    public List<Movie> toMovieList(ResultSet resultSet) {
        if(resultSet ==  null) {
            return null;
        }
        List<Movie> movieList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                movieList.add(toMovie(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Algo no ha funcionado: " + e.getMessage());
        }
        return movieList;
    }
}
