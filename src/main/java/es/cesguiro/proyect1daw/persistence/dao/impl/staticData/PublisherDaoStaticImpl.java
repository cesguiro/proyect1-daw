package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.entity.PublisherEntity;

import java.util.List;

public class PublisherDaoStaticImpl {

    private List<PublisherEntity> publisherEntityList = List.of(
            new PublisherEntity(1, "Editorial Anagrama"),
            new PublisherEntity(2, "Penguin Random House Grupo Editorial España"),
            new PublisherEntity(3, "Editorial Planeta"),
            new PublisherEntity(4, "DeBolsillo"),
            new PublisherEntity(5, "Minotauro")

    );
}
