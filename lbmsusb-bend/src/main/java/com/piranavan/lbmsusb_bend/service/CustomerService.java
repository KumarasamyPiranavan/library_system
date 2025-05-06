package com.piranavan.lbmsusb_bend.service;

import com.piranavan.lbmsusb_bend.model.Customer;
import com.piranavan.lbmsusb_bend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return (Customer)this.customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> searchCustomers(String keyword) {
        return this.customerRepository.searchCustomers(keyword);
    }
}
