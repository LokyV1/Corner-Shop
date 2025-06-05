package it.apulia.ecommerce.cornershop.service;


import it.apulia.ecommerce.cornershop.domain.Dipendente;
import it.apulia.ecommerce.cornershop.repository.DipendenteRepository;
import it.apulia.ecommerce.cornershop.rest.dto.DipendenteDTO;


public class DipendenteService extends AService<String, Dipendente, DipendenteDTO>{
    


    public DipendenteService(DipendenteRepository repo){
        super(repo);
    }

    @Override
    protected Dipendente map(DipendenteDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    protected Dipendente map(Dipendente entity, DipendenteDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

}
