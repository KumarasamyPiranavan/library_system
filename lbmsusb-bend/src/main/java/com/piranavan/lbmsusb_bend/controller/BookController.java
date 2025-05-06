package com.piranavan.lbmsusb_bend.controller;

import com.piranavan.lbmsusb_bend.model.Book;
import com.piranavan.lbmsusb_bend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(this.bookService.getAllBooks(), org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = this.bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = this.bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody Book book) {
        Book book1 = this.bookService.getBookById(id);
        if (book1 != null) {
            book.setId(id);
            this.bookService.updateBook(book);
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        Book book = this.bookService.getBookById(id);
        if (book != null) {
            this.bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {
        List<Book> books = this.bookService.searchBooks(keyword);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
