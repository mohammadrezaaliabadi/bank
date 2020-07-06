package com.example.bank.services;

import com.example.bank.web.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
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

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {
        //todo impl - would add a real impl to update Customer
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting a customer...");
    }
}
