package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente extends Persona {
    private Instant dataInizioAbbonamento;
    private Instant dataFineAbbonamento;

    @OneToMany(mappedBy = "cliente")
    private Set<Acquisto> acquisti;
}
