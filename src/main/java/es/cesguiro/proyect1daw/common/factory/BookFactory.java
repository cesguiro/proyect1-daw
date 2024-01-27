package es.cesguiro.proyect1daw.common.factory;

import es.cesguiro.proyect1daw.domain.repository.BookRepository;
import es.cesguiro.proyect1daw.domain.service.BookService;
import es.cesguiro.proyect1daw.domain.service.impl.BookServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.BookDaoImpl;
import es.cesguiro.proyect1daw.persistence.repositoryImpl.BookRepositoryImpl;
import lombok.Getter;

public class BookFactory {

    @Getter
    private static BookService bookService = createMovieService();

    @Getter
    private static BookRepository bookRepository = createMovieRepository();

    @Getter
    private static BookDao bookDao = createMovieDao();

    private BookFactory(){

    }

    private static BookService createMovieService() {
        if(bookService == null) {
            bookService = new BookServiceImpl(createMovieRepository());
        }
        return bookService;
    }

    private static BookRepository createMovieRepository() {
        if(bookRepository == null) {
            bookRepository = new BookRepositoryImpl(createMovieDao());
        }
        return bookRepository;
    }

    private static BookDao createMovieDao() {
        if(bookDao == null) {
            bookDao = new BookDaoImpl();
        }
        return bookDao;
    }
}
