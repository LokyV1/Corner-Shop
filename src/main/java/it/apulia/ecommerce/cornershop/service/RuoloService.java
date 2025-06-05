package it.apulia.ecommerce.cornershop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Ruolo;
import it.apulia.ecommerce.cornershop.repository.RuoloRepository;
import it.apulia.ecommerce.cornershop.rest.dto.RuoloDTO;
import lombok.Getter;
import lombok.Setter;



@Service
public class RuoloService extends AService<String, Ruolo, RuoloDTO>{

    public RuoloService(RuoloRepository repo){
        super(repo);
    }

    @Override
    protected Ruolo map(RuoloDTO dto){
        throw new UnsupportedOperationException("unimplemented method 'map'");
    }

    @Override
    protected Ruolo map(Ruolo entity, RuoloDTO dto){
        throw new UnsupportedOperationException("unimplemented method 'map'");
    }
    
}
