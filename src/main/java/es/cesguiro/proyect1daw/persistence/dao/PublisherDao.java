package es.cesguiro.proyect1daw.persistence.dao;

import es.cesguiro.proyect1daw.persistence.dao.entity.PublisherEntity;

import java.util.Optional;

public interface PublisherDao {
    Optional<PublisherEntity> findById(int publisherId);
}
