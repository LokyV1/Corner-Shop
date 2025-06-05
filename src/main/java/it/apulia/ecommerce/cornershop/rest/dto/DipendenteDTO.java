package it.apulia.ecommerce.cornershop.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DipendenteDTO extends PersonaDTO {
    private String matricola;
    private Float salario;
    
    private String ruoloId;
}
