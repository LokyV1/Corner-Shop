package it.apulia.ecommerce.cornershop.service;

import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.repository.ClienteRepository;
import it.apulia.ecommerce.cornershop.rest.dto.ClienteDTO;
import it.apulia.ecommerce.cornershop.domain.Cliente;


@Service
public class ClienteService extends AService<String, Cliente, ClienteDTO>{

    public ClienteService(ClienteRepository repo){
        super(repo);
    }

    @Override
    protected Cliente map(ClienteDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    protected Cliente map(Cliente entity, ClienteDTO dto){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
    
}
