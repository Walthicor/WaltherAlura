package com.walther.literalura.controller;

import com.walther.literalura.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private LibraryBookService bookService;

    @GetMapping("/search/title/{title}")
    public List<Book> searchByTitle(@PathVariable String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/search/author/{author}")
    public List<Book> searchByAuthor(@PathVariable String author) {
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/filter/theme/{theme}")
    public List<Book> filterByTheme(@PathVariable String theme) {
        return bookService.filterByTheme(theme);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Book> getDetails(@PathVariable Long id) {
        return bookService.getDetails(id);
    }

    @GetMapping("/popular")
    public List<Book> listPopularBooks() {
        return bookService.listPopularBooks();
    }
}
