package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Cliente;
import it.apulia.ecommerce.cornershop.repository.ClienteRepository;
import it.apulia.ecommerce.cornershop.rest.dto.ClienteDTO;

@Service
public class ClienteService extends AService<String, Cliente, ClienteDTO> {

    public ClienteService(ClienteRepository repo) {
        super(repo);
    }

    @Override
    protected Cliente map(ClienteDTO dto) {
        Cliente entity = new Cliente();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    protected Cliente map(Cliente entity, ClienteDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    protected Cliente mapPatch(Cliente entity, ClienteDTO dto) {
        if (Objects.nonNull(dto.getNome()))
            entity.setNome(dto.getNome());

        if (Objects.nonNull(dto.getCognome()))
            entity.setCognome(dto.getCognome());

        if (Objects.nonNull(dto.getDataNascita()))
            entity.setDataNascita(dto.getDataNascita());

        if (Objects.nonNull(dto.getDataInizioAbbonamento()))
            entity.setDataInizioAbbonamento(dto.getDataInizioAbbonamento());

        if (Objects.nonNull(dto.getDataFineAbbonamento()))
            entity.setDataFineAbbonamento(dto.getDataFineAbbonamento());

        return entity;
    }

}
