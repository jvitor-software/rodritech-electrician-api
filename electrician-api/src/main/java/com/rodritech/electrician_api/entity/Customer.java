package com.rodritech.electrician_api.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    // INJEÇÃO AQUI: Novo campo de documento
    @Column(nullable = false, unique = true, length = 50)
    private String nationalId;

    public Customer() {}

    // --- Getters ---
    public UUID getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    
    // INJEÇÃO AQUI: Getter do documento
    public String getNationalId() { return nationalId; }

    // --- Setters ---
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
    
    // INJEÇÃO AQUI: Setter do documento
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
}