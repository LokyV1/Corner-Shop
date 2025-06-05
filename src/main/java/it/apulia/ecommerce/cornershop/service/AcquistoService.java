package it.apulia.ecommerce.cornershop.service;

import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Acquisto;
import it.apulia.ecommerce.cornershop.repository.AcquistoRepository;
import it.apulia.ecommerce.cornershop.rest.dto.AcquistoDTO;

@Service
public class AcquistoService extends AService<String, Acquisto, AcquistoDTO>{

    public AcquistoService(AcquistoRepository repo){
        super(repo);
    }

    @Override
    protected Acquisto map(AcquistoDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    protected Acquisto map(Acquisto entity, AcquistoDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
    
}
