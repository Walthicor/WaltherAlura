package com.walther.literalura.service;

import com.walther.literalura.GutendexResponse;
import org.springframework.stereotype.Service;
import com.walther.literalura.model.Book;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class GutendexClient {
    private final RestTemplate restTemplate;

    public GutendexClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> searchBooks(String query) {
        String url = "https://gutendex.com/books/?search=" + query;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response.getResults();
    }
}
