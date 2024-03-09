package es.cesguiro.proyect1daw.persistence.dao.impl.jdbc;

import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public class BookDaoJdbcImpl implements BookDao {


    @Override
    public List<BookEntity> findAll() {
        /*String sql = "SELECT * FROM books";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            return bookMapper.toBookList(resultSet);
        } catch (Exception e) {
            throw new RuntimeException("Error al ejecutar la sentencia: " + sql);
        }*/
        return null;
    }

    @Override
    public Optional<BookEntity> findById(int id) {
        return Optional.empty();
    }

}
