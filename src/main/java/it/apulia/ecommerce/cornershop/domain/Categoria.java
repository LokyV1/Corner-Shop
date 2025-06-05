package it.apulia.ecommerce.cornershop.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria extends ADomain {
    private String nome;

    @ManyToMany(mappedBy = "categorie")
    private Set<Prodotto> prodotti;
}
