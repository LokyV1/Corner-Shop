package it.apulia.ecommerce.cornershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.apulia.ecommerce.cornershop.domain.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, String> {
    
}
