package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// ^^^ creano l'implementazione dei getter e i setter grazie al framework lombok
//valori del prodotto da vendere
public class Prodotto extends ADomain{
    private String nome;
    private Instant dataRilascio;
    private Instant dataArrivo;
    private long quantita;
    private float prezzo;
    private String produttore;
    private Integer ageRating;

    private Set<Categoria> categorie;
    private Set<Acquisto> acquisti;
}