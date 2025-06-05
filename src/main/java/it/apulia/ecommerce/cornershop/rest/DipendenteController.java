package it.apulia.ecommerce.cornershop.rest;

import java.util.List;

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

import it.apulia.ecommerce.cornershop.domain.Dipendente;
import it.apulia.ecommerce.cornershop.rest.dto.DipendenteDTO;
import it.apulia.ecommerce.cornershop.rest.dto.DipendenteResponseDTO;
import it.apulia.ecommerce.cornershop.service.DipendenteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dipendenti")
@RequiredArgsConstructor
public class DipendenteController {

    private final DipendenteService dipendenteService;

    private DipendenteResponseDTO map(Dipendente dipendente) {
        // TODO da finire
        DipendenteResponseDTO responseDTO = new DipendenteResponseDTO();
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DipendenteResponseDTO save(@RequestBody DipendenteDTO dto) throws Exception {
        Dipendente dipendente = dipendenteService.save(dto);
        return map(dipendente);
    }

    @PutMapping("/{id}")
    public DipendenteResponseDTO update(@PathVariable String id, @RequestBody DipendenteDTO dto) throws Exception {
        Dipendente dipendente = dipendenteService.update(id, dto);
        return map(dipendente);
    }

    @GetMapping("/{id}")
    public DipendenteResponseDTO getById(@PathVariable String id) throws Exception {
        return map(dipendenteService.getById(id));
    }

    @GetMapping
    public List<DipendenteResponseDTO> getAll() throws Exception {
        return dipendenteService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        dipendenteService.deleteById(id);
    }

}
