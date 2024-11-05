package com.walther.literalura;

import com.walther.literalura.model.Book;
import java.util.List;

public class GutendexResponse {
    private List<Book> results;

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }
}
