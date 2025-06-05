package it.apulia.ecommerce.cornershop.service;

import org.springframework.stereotype.Service;

import it.apulia.ecommerce.cornershop.domain.Ruolo;
import it.apulia.ecommerce.cornershop.repository.RuoloRepository;
import it.apulia.ecommerce.cornershop.rest.dto.RuoloDTO;

@Service
public class RuoloService extends AService<String, Ruolo, RuoloDTO>{

    public RuoloService(RuoloRepository repo) {
        super(repo);
    }
 
    @Override
    protected Ruolo map(RuoloDTO dto) {
        Ruolo ruolo = new Ruolo();
        ruolo.setNome(dto.getNome());
        ruolo.setCodice(dto.getCodice());
        return ruolo;
    }

    @Override
    protected Ruolo map(Ruolo entity, RuoloDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCodice(dto.getCodice());
        return entity;
    }
    
}
