package it.apulia.ecommerce.cornershop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dipendente extends Persona {
    private String matricola;
    private float salario;
    
    private Ruolo ruolo;
}
