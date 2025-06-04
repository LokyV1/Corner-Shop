package it.apulia.ecommerce.cornershop.domain;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
// ^^^ creano l'implementazione dei getter e i setter grazie al framework lombook
public class Persona extends ADomain{
    private String nome;
    private String cognome;
    private Instant dataNascita;
    
}
