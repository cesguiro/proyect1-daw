package es.cesguiro.proyect1daw.persistence.dao.impl;

import es.cesguiro.proyect1daw.domain.entity.Movie;
import es.cesguiro.proyect1daw.persistence.dao.MovieDao;
import es.cesguiro.proyect1daw.persistence.dao.db.DBConnection;
import es.cesguiro.proyect1daw.persistence.dao.mapper.MovieMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    private final DBConnection dbConnection;
    private final MovieMapper movieMapper;

    public MovieDaoImpl() {
        this.movieMapper = new MovieMapper();
        this.dbConnection = new DBConnection();
    }

    @Override
    public List<Movie> findAll() {
        String sql = "SELECT * FROM movies";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            return movieMapper.toMovieList(resultSet);
        } catch (Exception e) {
            throw new RuntimeException("Error al ejecutar la sentencia: " + sql);
        }
    }
}
