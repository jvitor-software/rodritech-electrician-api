package com.rodritech.electrician_api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "service_quotes")
public class ServiceQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 500)
    private String description;

    // Uso estratégico de BigDecimal para dados financeiros
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalValue;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // A Chave de Alavancagem: Relacionamento
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public ServiceQuote() {}

    // Getters
    public UUID getId() { return id; }
    public String getDescription() { return description; }
    public BigDecimal getTotalValue() { return totalValue; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Customer getCustomer() { return customer; }

    // Setters
    public void setDescription(String description) { this.description = description; }
    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}