package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaResponseDTO extends AResponseDTO {
    protected String nome;
    protected String cognome;
    protected Instant dataNascita;
}
