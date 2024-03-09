package es.cesguiro.proyect1daw.controller;

import es.cesguiro.proyect1daw.common.container.BookIoc;
import es.cesguiro.proyect1daw.common.exception.ResourceNotFoundException;
import es.cesguiro.proyect1daw.domain.entity.Book;
import es.cesguiro.proyect1daw.domain.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(BookController.URL)
public class BookController {

    public static final String URL = "/books";
    private final BookService bookService;

    public BookController() {
        this.bookService = BookIoc.getBookService();
    }

    @GetMapping()
    public String findAll(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable int id) {
        try {
            Book book = bookService.findById(id);
            model.addAttribute("book", book);
            return "bookDetail";
        } catch (ResourceNotFoundException e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }
}
