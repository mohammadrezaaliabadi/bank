package com.example.bank.services;


import com.example.bank.web.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID customerID);

    Customer saveCustomer(Customer customer);
}
