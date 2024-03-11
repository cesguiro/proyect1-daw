package es.cesguiro.proyect1daw.persistence.repository.impl;

import es.cesguiro.proyect1daw.common.container.BookAuthorIoc;
import es.cesguiro.proyect1daw.common.container.PublisherIoc;
import es.cesguiro.proyect1daw.domain.entity.Author;
import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.domain.entity.Publisher;
import es.cesguiro.proyect1daw.persistence.dao.BookAuthorDao;
import es.cesguiro.proyect1daw.persistence.dao.BookDao;
import es.cesguiro.proyect1daw.persistence.dao.entity.AuthorEntity;
import es.cesguiro.proyect1daw.persistence.dao.entity.BookEntity;
import es.cesguiro.proyect1daw.persistence.repository.BookRepository;
import es.cesguiro.proyect1daw.persistence.repository.mapper.AuthorMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.BookMapper;
import es.cesguiro.proyect1daw.persistence.repository.mapper.PublisherMapper;

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
        BookEntity bookEntity = bookDao.findById(id).orElse(null);
        if(bookEntity == null) {
            return Optional.empty();
        }
        Book book = BookMapper.toBook(bookEntity);

        Publisher publisher = PublisherMapper.toPublisher(PublisherIoc.getPublisherDao().findById(bookEntity.getPublisherId()).orElse(null));
        book.setPublisher(publisher);

        BookAuthorDao bookAuthorDao = BookAuthorIoc.getBookAuthorDao();
        List<AuthorEntity> authorEntityList = bookAuthorDao.findByBookId(bookEntity.getId());
        List<Author> authorList = authorEntityList.stream()
                .map(AuthorMapper::toAuthor)
                .toList();

        book.setAuthorList(authorList);

        return Optional.of(book);
    }
}
