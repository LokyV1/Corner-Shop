package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Acquisto;
import it.apulia.ecommerce.cornershop.repository.AcquistoRepository;
import it.apulia.ecommerce.cornershop.repository.ClienteRepository;
import it.apulia.ecommerce.cornershop.repository.ProdottoRepository;
import it.apulia.ecommerce.cornershop.rest.dto.AcquistoDTO;

@Service
public class AcquistoService extends AService<String, Acquisto, AcquistoDTO> {

    private final ClienteRepository clienteRepository;
    private final ProdottoRepository prodottoRepository;

    public AcquistoService(AcquistoRepository repo, ProdottoRepository prodottoRepository,
            ClienteRepository clienteRepository) {
        super(repo);
        this.clienteRepository = clienteRepository;
        this.prodottoRepository = prodottoRepository;
    }

    @Override
    protected Acquisto map(AcquistoDTO dto) {
        Acquisto entity = new Acquisto();
        BeanUtils.copyProperties(dto, entity);
        entity.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));
        entity.setProdotto(prodottoRepository.findById(dto.getProdottoId()).orElse(null));
        return entity;
    }

    @Override
    protected Acquisto map(Acquisto entity, AcquistoDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        entity.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));
        entity.setProdotto(prodottoRepository.findById(dto.getProdottoId()).orElse(null));
        return entity;
    }

    @Override
    protected Acquisto mapPatch(Acquisto entity, AcquistoDTO dto) {

        if (Objects.nonNull(dto.getQuantita()))
            entity.setQuantita(dto.getQuantita());

        if (Objects.nonNull(dto.getDataAcquisto()))
            entity.setDataAcquisto(dto.getDataAcquisto());

        if (Objects.nonNull(dto.getClienteId()))
            entity.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));

        if (Objects.nonNull(dto.getProdottoId()))
            entity.setProdotto(prodottoRepository.findById(dto.getProdottoId()).orElse(null));

        return entity;
    }

}
