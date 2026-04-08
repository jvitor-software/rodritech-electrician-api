package com.rodritech.electrician_api.repository;

import com.rodritech.electrician_api.entity.ServiceQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ServiceQuoteRepository extends JpaRepository<ServiceQuote, UUID> {
}