package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.domain.service.BookService;
import es.cesguiro.proyect1daw.domain.service.impl.BookServiceImpl;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.BookDaoStaticImpl;
import es.cesguiro.proyect1daw.persistence.repository.BookRepository;
import es.cesguiro.proyect1daw.persistence.repository.impl.BookRepositoryImpl;

public class BookIoc {

    private static BookService bookService;

    private static BookRepository bookRepository;

    private static BookDao bookDao;


    public static BookService getBookService() {
        if(bookService == null) {
            bookService = new BookServiceImpl(getBookRepository());
        }
        return bookService;
    }

    public static BookRepository getBookRepository() {
        if(bookRepository == null) {
            bookRepository = new BookRepositoryImpl(getBookDao());
        }
        return bookRepository;
    }

    public static BookDao getBookDao() {
        if(bookDao == null) {
            bookDao = new BookDaoStaticImpl();
        }
        return bookDao;
    }

}
