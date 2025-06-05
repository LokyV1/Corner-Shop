package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Categoria;
import it.apulia.ecommerce.cornershop.repository.CategoriaRepository;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaDTO;

@Service
public class CategoriaService extends AService<String, Categoria, CategoriaDTO> {

    public CategoriaService(CategoriaRepository repo) {
        super(repo);
    }

    @Override
    protected Categoria map(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    protected Categoria map(Categoria entity, CategoriaDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    protected Categoria mapPatch(Categoria entity, CategoriaDTO dto) {
        if (Objects.nonNull(dto.getNome()))
            entity.setNome(dto.getNome());
        return entity;
    }

}
