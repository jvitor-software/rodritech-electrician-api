package com.rodritech.electrician_api.repository;

import com.rodritech.electrician_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

// JpaRepository<Entidade, Tipo da Chave Primária>
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}