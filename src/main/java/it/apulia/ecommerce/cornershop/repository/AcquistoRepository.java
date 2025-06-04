package it.apulia.ecommerce.cornershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.apulia.ecommerce.cornershop.domain.Acquisto;


public interface AcquistoRepository extends JpaRepository<Acquisto, String> {
    
}
