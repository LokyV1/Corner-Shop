package it.apulia.ecommerce.cornershop.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuoloResponseDTO extends AResponseDTO {
    private String nome;
    private String codice;
}
