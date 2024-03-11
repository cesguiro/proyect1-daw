package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.persistence.dao.BookAuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.BookAuthorDaoStaticImpl;

public class BookAuthorIoc {

        private static BookAuthorDao bookAuthorDao;

        public static BookAuthorDao getBookAuthorDao() {
            if (bookAuthorDao == null) {
                bookAuthorDao = new BookAuthorDaoStaticImpl();
            }
            return bookAuthorDao;
        }
}
