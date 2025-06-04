package it.apulia.ecommerce.cornershop.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Ruolo extends ADomain{
    private String nome;
    private String codice;

    private Set<Dipendente> dipendenti;
}
