package it.apulia.ecommerce.cornershop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dipendente")
public class Dipendente extends Persona{
    private String matricola;
    private Float salario;

    @ManyToOne
    private Ruolo ruolo;
}
