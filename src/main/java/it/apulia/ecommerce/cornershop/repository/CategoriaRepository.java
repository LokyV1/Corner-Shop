package it.apulia.ecommerce.cornershop.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.apulia.ecommerce.cornershop.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String>{
    @Query("from Categoria where id in :ids")
    Set<Categoria> findAllByIds(@Param("ids") Set<String> ids);
}
