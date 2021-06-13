package ru.lid.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;
    private String title;
    private Date release;

    public Book(String title, Date release) {
        this.title = title;
        this.release = release;
    }
}
