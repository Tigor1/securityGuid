package ru.lid.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.lid.security.model.Book;

import java.util.Date;

@AllArgsConstructor
@Data
public class BookDTO {
    private String title;
    private Date release;

    public Book toBook() {
        return new Book(title, release);
    }
}
