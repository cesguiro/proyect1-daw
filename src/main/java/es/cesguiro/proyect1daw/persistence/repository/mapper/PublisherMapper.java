package es.cesguiro.proyect1daw.persistence.repository.mapper;

import es.cesguiro.proyect1daw.domain.entity.Publisher;
import es.cesguiro.proyect1daw.persistence.dao.entity.PublisherEntity;

public class PublisherMapper {

    public static Publisher toPublisher(PublisherEntity publisherEntity) {
        return new Publisher(publisherEntity.getId(), publisherEntity.getName());
    }
}
