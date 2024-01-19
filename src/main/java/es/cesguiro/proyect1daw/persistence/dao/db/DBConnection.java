package es.cesguiro.proyect1daw.persistence.dao.db;

import es.cesguiro.proyect1daw.common.AppPropertiesReader;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    @Getter
    private final Connection connection;

    public DBConnection() {
        System.out.println("Estableciendo conexión....");
        try {
            connection = DriverManager.getConnection(
                    AppPropertiesReader.getProperty("app.datasource.url"),
                    AppPropertiesReader.getProperty("app.datasource.username"),
                    AppPropertiesReader.getProperty("app.datasource.password")
            );
            System.out.println("Conexión establecida con la bbdd con los parámetros: ");
            System.out.println(this.getParameters());
        } catch (SQLException e) {
            throw new RuntimeException("Connection paramaters :\n\n" + getParameters() + "\nOriginal exception message: " + e.getMessage());
        }
    }


    private String getParameters (){
        return String.format("url: %s\nUser: %s\nPassword: %s\n",
                AppPropertiesReader.getProperty("app.datasource.url"),
                AppPropertiesReader.getProperty("app.datasource.username"),
                AppPropertiesReader.getProperty("app.datasource.password")
        );
    }

}
