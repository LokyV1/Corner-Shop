package it.apulia.ecommerce.cornershop.service;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import it.apulia.ecommerce.cornershop.domain.Prodotto;
import it.apulia.ecommerce.cornershop.repository.CategoriaRepository;
import it.apulia.ecommerce.cornershop.repository.ProdottoRepository;
import it.apulia.ecommerce.cornershop.rest.dto.ProdottoDTO;

@Service
public class ProdottoService extends AService<String, Prodotto, ProdottoDTO> {

    private final CategoriaRepository categoriaRepository;

    public ProdottoService(ProdottoRepository repo, CategoriaRepository categoriaRepository) {
        super(repo);
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    protected Prodotto map(ProdottoDTO dto) {
        Prodotto prodotto = new Prodotto();
        BeanUtils.copyProperties(dto, prodotto);
        prodotto.setCategorie(categoriaRepository.findAllByIds(dto.getCategorieIds()));

        return prodotto;
    }

    @Override
    protected Prodotto map(Prodotto entity, ProdottoDTO dto) {
        BeanUtils.copyProperties(dto, entity);
        entity.setCategorie(categoriaRepository.findAllByIds(dto.getCategorieIds()));
        return entity;
    }

    @Override
    protected Prodotto mapPatch(Prodotto entity, ProdottoDTO dto) {
        if (Objects.nonNull(dto.getNome()))
            entity.setNome(dto.getNome());

        if (Objects.nonNull(dto.getAgeRating()))
            entity.setAgeRating(dto.getAgeRating());

        if (Objects.nonNull(dto.getPrezzo()))
            entity.setPrezzo(dto.getPrezzo());

        if (Objects.nonNull(dto.getProduttore()))
            entity.setProduttore(dto.getProduttore());

        if (Objects.nonNull(dto.getQuantita()))
            entity.setQuantita(dto.getQuantita());

        if (Objects.nonNull(dto.getDataArrivo()))
            entity.setDataArrivo(dto.getDataArrivo());

        if (Objects.nonNull(dto.getDataRilascio()))
            entity.setDataRilascio(dto.getDataRilascio());

        if (Objects.nonNull(dto.getCategorieIds()))
            entity.setCategorie(categoriaRepository.findAllByIds(dto.getCategorieIds()));

        return entity;
    }

}
