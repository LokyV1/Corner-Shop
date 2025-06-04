package it.apulia.ecommerce.cornershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.apulia.ecommerce.cornershop.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String>{
    
}
