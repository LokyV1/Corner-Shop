package it.apulia.ecommerce.cornershop.service;

import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Categoria;
import it.apulia.ecommerce.cornershop.repository.CategoriaRepository;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaDTO;

@Service
public class CategoriaService extends AService<String, Categoria, CategoriaDTO>{

    public CategoriaService(CategoriaRepository repo){
        super(repo);
    }

    @Override
    protected Categoria map(CategoriaDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    protected Categoria map(Categoria entity, CategoriaDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
    
}
