package es.cesguiro.proyect1daw.common.container;

import es.cesguiro.proyect1daw.persistence.dao.PublisherDao;
import es.cesguiro.proyect1daw.persistence.dao.impl.staticData.PublisherDaoStaticImpl;

public class PublisherIoc {

    private static PublisherDao publisherDao;

    public static PublisherDao getPublisherDao() {
        if (publisherDao == null) {
            publisherDao = new PublisherDaoStaticImpl();
        }
        return publisherDao;
    }
}
