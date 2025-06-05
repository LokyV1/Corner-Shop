package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "acquisto")
public class Acquisto extends ADomain {
    
    private Integer quantita;
    private Instant dataAcquisto;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Prodotto prodotto;
}
