package com.piranavan.lbmsusb_bend.controller;

import com.piranavan.lbmsusb_bend.model.Borrow;
import com.piranavan.lbmsusb_bend.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping("all")
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        return new ResponseEntity<>(this.borrowService.getAllBorrows(), org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        Borrow borrow = this.borrowService.getBorrowById(id);
        if (borrow != null) {
            return new ResponseEntity<>(borrow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Borrow> addBorrow(@RequestBody Borrow borrow) {
        Borrow savedBorrow = this.borrowService.addBorrow(borrow);
        if (savedBorrow != null) {
            return new ResponseEntity<>(savedBorrow, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrow(@PathVariable Long id) {
        Borrow borrow = this.borrowService.getBorrowById(id);
        if (borrow != null) {
            this.borrowService.deleteBorrow(id);
            return new ResponseEntity<>("Borrow deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Borrow not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Borrow>> searchBorrows(@RequestParam String keyword) {
        List<Borrow> borrows = this.borrowService.searchBorrows(keyword);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }
}
