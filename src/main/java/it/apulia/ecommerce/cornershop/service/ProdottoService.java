package it.apulia.ecommerce.cornershop.service;

import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Prodotto;
import it.apulia.ecommerce.cornershop.repository.ProdottoRepository;
import it.apulia.ecommerce.cornershop.rest.dto.ProdottoDTO;




@Service
public class ProdottoService extends AService<String, Prodotto, ProdottoDTO>{
    
    public ProdottoService(ProdottoRepository repo){
        super(repo);
    }
    
    @Override
    protected Prodotto map (ProdottoDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    protected Prodotto map (Prodotto entity, ProdottoDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
}
