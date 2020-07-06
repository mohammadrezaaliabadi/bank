package com.example.bank.services;

import com.example.bank.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerID) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Ali").address("Minab").build();
    }
}
