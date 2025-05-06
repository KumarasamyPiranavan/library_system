package com.piranavan.lbmsusb_bend.repository;

import com.piranavan.lbmsusb_bend.model.Book;
import com.piranavan.lbmsusb_bend.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    @Query("SELECT br FROM Borrow br " +
            "JOIN br.bookId b " +
            "JOIN br.customerId c " +
            "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.part) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.category) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.publication) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Borrow> searchBorrowsByKeyword(@Param("keyword") String keyword);
}
