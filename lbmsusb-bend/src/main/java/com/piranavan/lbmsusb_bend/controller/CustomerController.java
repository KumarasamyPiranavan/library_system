package com.piranavan.lbmsusb_bend.controller;

import com.piranavan.lbmsusb_bend.model.Customer;
import com.piranavan.lbmsusb_bend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(this.customerService.getAllCustomer(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(this.customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer existingCustomer = this.customerService.getCustomerById(id);
        if (existingCustomer != null) {
            customer.setId(id);
            this.customerService.updateCustomer(customer);
            return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        Customer customer = this.customerService.getCustomerById(id);
        if (customer != null) {
            this.customerService.deleteCustomer(id);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String keyword) {
        List<Customer> customers = this.customerService.searchCustomers(keyword);
            return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
