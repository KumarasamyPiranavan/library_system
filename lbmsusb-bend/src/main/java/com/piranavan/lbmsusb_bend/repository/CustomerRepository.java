package com.piranavan.lbmsusb_bend.repository;

import com.piranavan.lbmsusb_bend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM Customer c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.address) LIKE LOWER(CONCAT('%', :keyword, '%')) ")
    List<Customer> searchCustomers(String keyword);
}
