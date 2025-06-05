package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import it.apulia.ecommerce.cornershop.domain.Dipendente;
import it.apulia.ecommerce.cornershop.repository.DipendenteRepository;
import it.apulia.ecommerce.cornershop.repository.RuoloRepository;
import it.apulia.ecommerce.cornershop.rest.dto.DipendenteDTO;

@Service
public class DipendenteService extends AService<String, Dipendente, DipendenteDTO> {

    private final RuoloRepository ruoloRepository;

    public DipendenteService(DipendenteRepository repo, RuoloRepository ruoloRepository) {
        super(repo);
        this.ruoloRepository = ruoloRepository;
    }

    @Override
    protected Dipendente map(DipendenteDTO dto) {
        Dipendente entity = new Dipendente();
        BeanUtils.copyProperties(dto, entity);
        entity.setRuolo(ruoloRepository.findById(dto.getRuoloId()).orElse(null));
        return entity;
    }

    @Override
    protected Dipendente map(Dipendente entity, DipendenteDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        entity.setRuolo(ruoloRepository.findById(dto.getRuoloId()).orElse(null));
        return entity;
    }

    @Override
    protected Dipendente mapPatch(Dipendente entity, DipendenteDTO dto) {

        if (Objects.nonNull(dto.getNome()))
            entity.setNome(dto.getNome());

        if (Objects.nonNull(dto.getCognome()))
            entity.setCognome(dto.getCognome());

        if (Objects.nonNull(dto.getDataNascita()))
            entity.setDataNascita(dto.getDataNascita());

        if (Objects.nonNull(dto.getMatricola()))
            entity.setMatricola(dto.getMatricola());

        if (Objects.nonNull(dto.getSalario()))
            entity.setSalario(dto.getSalario());

        if (Objects.nonNull(dto.getRuoloId()))
            entity.setRuolo(ruoloRepository.findById(dto.getRuoloId()).orElse(null));
            
        return entity;
    }

}
