package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Cliente extends Persona{
    private Instant dataInizioAbbonamento;
    private Instant dataFineAbbonamento;

    private Set<Acquisto> acquisti;
}