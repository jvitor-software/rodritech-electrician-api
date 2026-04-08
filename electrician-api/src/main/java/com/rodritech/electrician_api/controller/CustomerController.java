package com.rodritech.electrician_api.controller;

import com.rodritech.electrician_api.entity.Customer;
import com.rodritech.electrician_api.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repository;

    // Construtor para Injeção de Dependência
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }
}