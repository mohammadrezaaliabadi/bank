package com.example.bank.web.v2;


import com.example.bank.services.CustomerService;
import com.example.bank.web.controller.v2.CustomerController2;
import com.example.bank.web.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableWebMvc
@WebMvcTest(CustomerController2.class)
public class CustomerControllerTest2 {
    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    Customer validCustomer;

    @BeforeEach
    public void setUp() {
        validCustomer = Customer.builder().id(UUID.randomUUID()).name("Ali").address("Minab").build();
    }

    @Test
    public void getCustomer() throws Exception {
        given(customerService.getCustomerById(any(UUID.class))).willReturn(validCustomer);

        mockMvc.perform(get("/api/v2/customer/" + validCustomer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validCustomer.getId().toString())))
                .andExpect(jsonPath("$.name", is("Ali")));

    }

    @Test
    public void handlerPost() throws Exception {
        //given
        Customer customer = validCustomer;
        customer.setId(null);
        Customer saveCustomer = Customer.builder().id(UUID.randomUUID()).name("Reza").address("Bandar").build();
        String customerJson = objectmapper.writeValueAsString(customer);

        given(customerService.saveCustomer(any())).willReturn(saveCustomer);

        mockMvc.perform(post("/api/v2/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handlerUpdate() throws Exception {
        Customer customer = validCustomer;
        customer.setId(null);
        String customerJson = objectmapper.writeValueAsString(customer);
        mockMvc.perform(put("/api/v2/customer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isNoContent());

        then(customerService).should().updateCustomer(any(), any());
    }

    @Test
    public void handleDelete() throws Exception {
        mockMvc.perform(delete("/api/v2/customer/" + UUID.randomUUID().toString()))
                .andExpect(status().isNoContent());
    }

}

