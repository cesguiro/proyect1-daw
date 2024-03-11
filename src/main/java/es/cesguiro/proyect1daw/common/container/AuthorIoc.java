package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.persistence.dao.AuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.AuthorDaoStaticImpl;

public class AuthorIoc {

    private static AuthorDao authorDao;

    public static AuthorDao getAuthorDao() {
        if (authorDao == null) {
            authorDao = new AuthorDaoStaticImpl();
        }
        return authorDao;
    }
}
