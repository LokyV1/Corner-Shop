package it.apulia.ecommerce.cornershop.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
// ^^^ creano l'implementazione dei getter e i setter grazie al framework lombook
public class Categoria extends ADomain{
    private String nome;

    private Set<Prodotto> prodotti;
    
}