package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prodotto")
public class Prodotto extends ADomain {
    private String nome;
    private Instant dataRilascio;
    private Instant dataArrivo;
    private Long quantita;
    private Float prezzo;
    private String produttore;
    private Integer ageRating;

    @ManyToMany
    private Set<Categoria> categorie;

    @OneToMany(mappedBy = "prodotto")
    private Set<Acquisto> acquisti;
}
