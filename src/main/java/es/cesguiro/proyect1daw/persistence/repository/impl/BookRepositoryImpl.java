package es.cesguiro.proyect1daw.persistence.repository.impl;

import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.BookEntity;
import es.cesguiro.proyect1daw.persistence.repository.BookRepository;
import es.cesguiro.proyect1daw.persistence.repository.mapper.BookMapper;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;

    public BookRepositoryImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAll() {
        List<BookEntity> bookEntityList = bookDao.findAll();
        List<Book> bookList = bookEntityList.stream()
                .map(BookMapper::toBook)
                .toList();

        return bookList;
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.ofNullable(BookMapper.toBook(bookDao.findById(id).orElse(null)));
    }
}
