package com.piranavan.lbmsusb_bend.service;

import com.piranavan.lbmsusb_bend.model.Book;
import com.piranavan.lbmsusb_bend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {   return this.bookRepository.findAll();
    }

    public Book getBookById(String id) {    return this.bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {    return this.bookRepository.save(book);
    }

    public Book updateBook(Book book) { return this.bookRepository.save(book);
    }

    public void deleteBook(String id) { this.bookRepository.findById(id).orElse(null);
    }

    public List<Book> searchBooks(String keyword) {
        return this.bookRepository.searchBooks(keyword);
    }

}
