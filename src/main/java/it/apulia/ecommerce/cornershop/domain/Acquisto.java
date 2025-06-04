package it.apulia.ecommerce.cornershop.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;


@Getter
@Setter
public class Acquisto extends ADomain {
    private Integer quantita;
    private Instant dataAcquisto;

    private Cliente cliente;
    private Prodotto prodotto;
}