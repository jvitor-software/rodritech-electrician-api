package com.rodritech.electrician_api.controller;

import com.rodritech.electrician_api.entity.Customer;
import com.rodritech.electrician_api.entity.ServiceQuote;
import com.rodritech.electrician_api.repository.CustomerRepository;
import com.rodritech.electrician_api.repository.ServiceQuoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/quotes")
public class ServiceQuoteController {

    private final ServiceQuoteRepository quoteRepository;
    private final CustomerRepository customerRepository;

    // Injetamos agora OS DOIS repositórios
    public ServiceQuoteController(ServiceQuoteRepository quoteRepository, CustomerRepository customerRepository) {
        this.quoteRepository = quoteRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ServiceQuote createQuote(@RequestBody ServiceQuote quote) {
        // 1. Validamos se o ID do cliente veio na requisição
        if (quote.getCustomer() == null || quote.getCustomer().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID do cliente é obrigatório para criar um orçamento.");
        }

        // 2. Buscamos o cliente real no banco de dados
        Customer realCustomer = customerRepository.findById(quote.getCustomer().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado no banco de dados."));

        // 3. Substituímos o "Cliente Zumbi" pelo "Cliente Real" no objeto do orçamento
        quote.setCustomer(realCustomer);

        // 4. Salvamos e retornamos o orçamento completo
        return quoteRepository.save(quote);
    }
}