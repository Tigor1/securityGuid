package ru.lid.security.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.lid.security.dto.BookDTO;
import ru.lid.security.model.Book;
import ru.lid.security.repositories.BookRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookRepository.save(bookDTO.toBook());
    }
}
