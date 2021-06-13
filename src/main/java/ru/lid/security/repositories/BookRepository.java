package ru.lid.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lid.security.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
