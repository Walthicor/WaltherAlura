package com.walther.literalura.controller;

import com.walther.literalura.model.Book;
import com.walther.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryBookService {

    private final BookRepository bookRepository;

    // Constructor para la inyección de dependencias de BookRepository
    @Autowired
    public LibraryBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Método para buscar libros por título
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    // Método para buscar libros por autor
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    // Método para filtrar libros por tema
    public List<Book> filterByTheme(String theme) {
        return bookRepository.findByThemeContaining(theme);
    }

    // Método para obtener detalles de un libro específico
    public Optional<Book> getBookDetails(Long id) {
        return bookRepository.findById(id);
    }

    // Método para listar los libros populares (puedes personalizar la lógica según sea necesario)
    public List<Book> listPopularBooks() {
        return bookRepository.findTop10ByOrderByPopularityDesc();
    }

    public ResponseEntity<Book> getDetails(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

