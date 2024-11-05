package com.walther.literalura.service;

import com.walther.literalura.model.Book;
import com.walther.literalura.repository.BookRepository;
import com.walther.literalura.service.GutendexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GutendexClient gutendexClient;

    @Autowired
    public BookService(BookRepository bookRepository, GutendexClient gutendexClient) {
        this.bookRepository = bookRepository;
        this.gutendexClient = gutendexClient;
    }

    public List<Book> searchBooks(String query) {
        // Aquí implementa la lógica para buscar libros
        return List.of(); // Este es un ejemplo de retorno vacío
    }

    public List<Book> searchByTitle(String title) {
        List<Book> gutendexBooks = gutendexClient.searchBooks(title);
        // Aquí puedes procesar y guardar los libros en tu base de datos si lo deseas
        return gutendexBooks;
    }

    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    public List<Book> filterByTheme(String theme) {
        return bookRepository.findByThemeContaining(theme);
    }

    public Optional<Book> getBookDetails(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> listPopularBooks() {
        return bookRepository.findAll(); // Ajustar según tus criterios de popularidad
    }
}



