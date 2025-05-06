package com.piranavan.lbmsusb_bend.service;

import com.piranavan.lbmsusb_bend.model.Book;
import com.piranavan.lbmsusb_bend.model.Borrow;
import com.piranavan.lbmsusb_bend.model.Customer;
import com.piranavan.lbmsusb_bend.repository.BookRepository;
import com.piranavan.lbmsusb_bend.repository.BorrowRepository;
import com.piranavan.lbmsusb_bend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public List<Borrow> getAllBorrows() {
        return this.borrowRepository.findAll();
    }

    public Borrow getBorrowById(Long id) {
        return this.borrowRepository.findById(id).orElse(null);
    }

    public Borrow addBorrow(Borrow borrow) {
        return this.borrowRepository.save(borrow);
    }

    public void deleteBorrow(Long id) {
        Borrow borrow = this.borrowRepository.findById(id).orElse(null);
        if (borrow != null) {
            this.borrowRepository.delete(borrow);
        }
    }

    public List<Borrow> searchBorrows(String keyword) {
        return borrowRepository.searchBorrowsByKeyword(keyword);
    }
}
