package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(dto, ruolo);
        return ruolo;
    }

    @Override
    protected Ruolo map(Ruolo entity, RuoloDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    protected Ruolo mapPatch(Ruolo entity, RuoloDTO dto) {
        if(Objects.nonNull(dto.getNome()))
            entity.setNome(dto.getNome());
        
        if(Objects.nonNull(dto.getCodice()))
            entity.setCodice(dto.getCodice());
        
        return entity;
    }
    
}
