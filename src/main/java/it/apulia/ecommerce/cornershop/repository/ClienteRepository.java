package it.apulia.ecommerce.cornershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.apulia.ecommerce.cornershop.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
}
