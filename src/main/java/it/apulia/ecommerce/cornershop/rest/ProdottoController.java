package it.apulia.ecommerce.cornershop.rest;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import it.apulia.ecommerce.cornershop.domain.Prodotto;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaResponseDTO;
import it.apulia.ecommerce.cornershop.rest.dto.ProdottoDTO;
import it.apulia.ecommerce.cornershop.rest.dto.ProdottoResponseDTO;
import it.apulia.ecommerce.cornershop.service.ProdottoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prodotti")
@RequiredArgsConstructor
public class ProdottoController {

    private final ProdottoService prodottoService;

    private ProdottoResponseDTO map(Prodotto prodotto) {
        ProdottoResponseDTO responseDTO = new ProdottoResponseDTO();
        BeanUtils.copyProperties(prodotto, responseDTO);
        
        responseDTO.setCategorie(prodotto.getCategorie().stream().map(v -> {
            CategoriaResponseDTO cDTO = new CategoriaResponseDTO();
            BeanUtils.copyProperties(v, cDTO);
            return cDTO;
        }).toList());
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProdottoResponseDTO save(@RequestBody ProdottoDTO dto) throws Exception {
        Prodotto prodotto = prodottoService.save(dto);
        return map(prodotto);
    }

    @PutMapping("/{id}")
    public ProdottoResponseDTO update(@PathVariable String id, @RequestBody ProdottoDTO dto) throws Exception {
        Prodotto prodotto = prodottoService.update(id, dto);
        return map(prodotto);
    }

    @GetMapping("/{id}")
    public ProdottoResponseDTO getById(@PathVariable String id) throws Exception {
        return map(prodottoService.getById(id));
    }

    @GetMapping
    public List<ProdottoResponseDTO> getAll() throws Exception {
        return prodottoService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        prodottoService.deleteById(id);
    }

}
