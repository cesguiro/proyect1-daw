package es.cesguiro.proyect1daw.persistence.dao.impl.staticData;

import es.cesguiro.proyect1daw.persistence.dao.PublisherDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.PublisherEntity;

import java.util.List;
import java.util.Optional;

public class PublisherDaoStaticImpl implements PublisherDao {

    private List<PublisherEntity> publisherEntityList = List.of(
            new PublisherEntity(1, "Editorial Anagrama"),
            new PublisherEntity(2, "Penguin Random House Grupo Editorial España"),
            new PublisherEntity(3, "Editorial Planeta"),
            new PublisherEntity(4, "DeBolsillo"),
            new PublisherEntity(5, "Minotauro")

    );

    @Override
    public Optional<PublisherEntity> findById(int publisherId) {
        return publisherEntityList.stream()
                .filter(publisherEntity -> publisherEntity.getId() == publisherId)
                .findFirst();
    }
}
