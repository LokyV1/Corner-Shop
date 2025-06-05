package it.apulia.ecommerce.cornershop.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DipendenteResponseDTO extends PersonaResponseDTO {
    private String matricola;
    private Float salario;

    private RuoloDTO ruolo;
}
