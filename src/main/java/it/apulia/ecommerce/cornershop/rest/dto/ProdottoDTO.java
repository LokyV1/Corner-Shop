package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdottoDTO {
    private String nome;
    private Instant dataRilascio;
    private Instant dataArrivo;
    private Long quantita;
    private Float prezzo;
    private String produttore;
    private Integer ageRating;
    
    private Set<String> categorieIds;
}
