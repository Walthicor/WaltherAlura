package com.walther.literalura.repository;

import com.walther.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByThemeContaining(String theme);
    List<Book> findByLanguage(String language);
    List<Book> findByGutendexId(String gutendexId);
    List<Book> findTop10ByOrderByPopularityDesc();


}
