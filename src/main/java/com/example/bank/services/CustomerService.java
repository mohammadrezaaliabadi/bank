package com.example.bank.services;

import com.example.bank.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);
}
