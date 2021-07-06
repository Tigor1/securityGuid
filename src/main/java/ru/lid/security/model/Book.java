package ru.lid.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(schema = "principal", name = "book")
public class Book {
    @Id
//    @SequenceGenerator(schema = "principal", name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private Date release;

    public Book(String title, Date release) {
        this.title = title;
        this.release = release;
    }
}
