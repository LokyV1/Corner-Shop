package it.apulia.ecommerce.cornershop.rest;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.apulia.ecommerce.cornershop.domain.Acquisto;
import it.apulia.ecommerce.cornershop.domain.Cliente;
import it.apulia.ecommerce.cornershop.rest.dto.AcquistoDTO;
import it.apulia.ecommerce.cornershop.rest.dto.AcquistoResponseDTO;
import it.apulia.ecommerce.cornershop.rest.dto.CategoriaResponseDTO;
import it.apulia.ecommerce.cornershop.rest.dto.ClienteResponseDTO;
import it.apulia.ecommerce.cornershop.rest.dto.ProdottoResponseDTO;
import it.apulia.ecommerce.cornershop.service.AcquistoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acquisti")
@RequiredArgsConstructor
public class AcquistoController {

    private final AcquistoService acquistoService;

    private AcquistoResponseDTO map(Acquisto acquisto) {
        AcquistoResponseDTO responseDTO = new AcquistoResponseDTO();
        ClienteResponseDTO clienteDTO = new ClienteResponseDTO();
        ProdottoResponseDTO prodottoDTO = new ProdottoResponseDTO();

        BeanUtils.copyProperties(acquisto, responseDTO);
        BeanUtils.copyProperties(acquisto.getCliente(), clienteDTO);
        BeanUtils.copyProperties(acquisto.getProdotto(), prodottoDTO);
        prodottoDTO.setCategorie(acquisto.getProdotto().getCategorie().stream().map(v -> {
            CategoriaResponseDTO cDTO = new CategoriaResponseDTO();
            BeanUtils.copyProperties(v, cDTO);
            return cDTO;
        }).toList());

        responseDTO.setCliente(clienteDTO);
        responseDTO.setProdotto(prodottoDTO);
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AcquistoResponseDTO save(@RequestBody AcquistoDTO dto) throws Exception {
        Acquisto acquisto = acquistoService.save(dto);
        return map(acquisto);
    }

    @PutMapping("/{id}")
    public AcquistoResponseDTO update(@PathVariable String id, @RequestBody AcquistoDTO dto) throws Exception {
        Acquisto acquisto = acquistoService.update(id, dto);
        return map(acquisto);
    }

    @GetMapping("/{id}")
    public AcquistoResponseDTO getById(@PathVariable String id) throws Exception {
        return map(acquistoService.getById(id));
    }

    @GetMapping
    public List<AcquistoResponseDTO> getAll(@RequestParam(name = "clienteId", required = false) String id)
            throws Exception {
        if (Objects.nonNull(id)) {
            Acquisto acquisto = new Acquisto();
            Cliente cliente = new Cliente();
            cliente.setId(id);
            acquisto.setCliente(cliente);

            return acquistoService.getAll(Example.of(acquisto)).stream().map(this::map).toList();
        } else
            return acquistoService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        acquistoService.deleteById(id);
    }

}
