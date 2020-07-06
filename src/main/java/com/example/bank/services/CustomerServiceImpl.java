package com.example.bank.services;

import com.example.bank.web.model.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomerById(UUID customerID) {
        return Customer.builder().id(UUID.randomUUID()).name("Ali").address("Minab").build();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return Customer.builder().id(UUID.randomUUID()).build();
    }
}
