package it.apulia.ecommerce.cornershop.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ruolo")
public class Ruolo extends ADomain{
    private String nome;
    private String codice;

    @OneToMany(mappedBy = "ruolo")
    private Set<Dipendente> dipendenti;
}
