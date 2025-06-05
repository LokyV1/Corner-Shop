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

import it.apulia.ecommerce.cornershop.domain.Ruolo;
import it.apulia.ecommerce.cornershop.rest.dto.RuoloDTO;
import it.apulia.ecommerce.cornershop.rest.dto.RuoloResponseDTO;
import it.apulia.ecommerce.cornershop.service.RuoloService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ruoli")
@RequiredArgsConstructor
public class RuoloController {

    private final RuoloService ruoloService;

    private RuoloResponseDTO map(Ruolo ruolo) {
        RuoloResponseDTO responseDTO = new RuoloResponseDTO();
        responseDTO.setId(ruolo.getId());
        responseDTO.setNome(ruolo.getNome());
        responseDTO.setCodice(ruolo.getCodice());
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RuoloResponseDTO save(@RequestBody RuoloDTO dto) throws Exception {
        Ruolo ruolo = ruoloService.save(dto);
        return map(ruolo);
    }

    @PutMapping("/{id}")
    public RuoloResponseDTO update(@PathVariable String id, @RequestBody RuoloDTO dto) throws Exception {
        Ruolo ruolo = ruoloService.update(id, dto);
        return map(ruolo);
    }

    @GetMapping("/{id}")
    public RuoloResponseDTO getById(@PathVariable String id) throws Exception {
        return map(ruoloService.getById(id));
    }

    @GetMapping
    public List<RuoloResponseDTO> getAll() throws Exception {
        return ruoloService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        ruoloService.deleteById(id);
    }

}
