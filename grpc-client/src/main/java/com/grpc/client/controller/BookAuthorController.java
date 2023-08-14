package com.grpc.client.controller;

import com.grpc.client.service.BookAuthorClientService;
import com.google.protobuf.Descriptors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookAuthorController {

    private final BookAuthorClientService bookAuthorClientService;

    public BookAuthorController(BookAuthorClientService bookAuthorClientService) {
        this.bookAuthorClientService = bookAuthorClientService;
    }

    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(id));
    }

    @GetMapping("/book/{authorId}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthor(@PathVariable String authorId) throws InterruptedException {
        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(authorId));
    }
}
