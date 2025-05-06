package com.piranavan.lbmsusb_bend.repository;

import com.piranavan.lbmsusb_bend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.part) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.category) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.publication) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> searchBooks(String keyword);
}
