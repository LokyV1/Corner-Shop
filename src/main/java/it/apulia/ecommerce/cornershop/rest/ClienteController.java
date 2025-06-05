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
import it.apulia.ecommerce.cornershop.domain.Cliente;
import it.apulia.ecommerce.cornershop.rest.dto.ClienteDTO;
import it.apulia.ecommerce.cornershop.rest.dto.ClienteResponseDTO;
import it.apulia.ecommerce.cornershop.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clienti")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    private ClienteResponseDTO map(Cliente cliente) {
        // TODO da finire
        ClienteResponseDTO responseDTO = new ClienteResponseDTO();
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClienteResponseDTO save(@RequestBody ClienteDTO dto) throws Exception {
        Cliente cliente = clienteService.save(dto);
        return map(cliente);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO update(@PathVariable String id, @RequestBody ClienteDTO dto) throws Exception {
        Cliente cliente = clienteService.update(id, dto);
        return map(cliente);
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO getById(@PathVariable String id) throws Exception {
        return map(clienteService.getById(id));
    }

    @GetMapping
    public List<ClienteResponseDTO> getAll() throws Exception {
        return clienteService.getAll(null).stream().map(this::map).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) throws Exception {
        clienteService.deleteById(id);
    }

}
