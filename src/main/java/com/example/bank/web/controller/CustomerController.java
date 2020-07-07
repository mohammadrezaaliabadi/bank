package com.example.bank.web.controller;

import com.example.bank.services.CustomerService;
import com.example.bank.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/customer")
@RestController
@Slf4j
@Validated
public class CustomerController {

    @Qualifier("customerService")
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull @PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@NotNull @Valid @RequestBody CustomerDto customer) {
        CustomerDto customer1 = customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/customer/" + customer1.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@NotNull @PathVariable("customerId") UUID customerId, @NotNull @Valid @RequestBody CustomerDto customer) {
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@NotNull @PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }

}
