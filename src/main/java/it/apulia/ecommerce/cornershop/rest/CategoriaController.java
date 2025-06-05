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
import it.apulia.ecommerce.cornershop.domain.Categoria;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaDTO;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaResponseDTO;
import it.apulia.ecommerce.cornershop.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorie")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    private CategoriaResponseDTO map(Categoria categoria) {
        CategoriaResponseDTO responseDTO = new CategoriaResponseDTO();
        BeanUtils.copyProperties(categoria, responseDTO);
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoriaResponseDTO save(@RequestBody CategoriaDTO dto) throws Exception {
        Categoria categoria = categoriaService.save(dto);
        return map(categoria);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO update(@PathVariable String id, @RequestBody CategoriaDTO dto) throws Exception {
        Categoria categoria = categoriaService.update(id, dto);
        return map(categoria);
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO getById(@PathVariable String id) throws Exception {
        return map(categoriaService.getById(id));
    }

    @GetMapping
    public List<CategoriaResponseDTO> getAll() throws Exception {
        return categoriaService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        categoriaService.deleteById(id);
    }

}
