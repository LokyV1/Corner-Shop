package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends PersonaDTO {
    private Instant dataInizioAbbonamento;
    private Instant dataFineAbbonamento;
}
