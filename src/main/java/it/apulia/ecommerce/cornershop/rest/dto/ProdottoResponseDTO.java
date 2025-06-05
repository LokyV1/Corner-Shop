package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdottoResponseDTO extends AResponseDTO {
    private String nome;
    private Instant dataRilascio;
    private Instant dataArrivo;
    private Long quantita;
    private Float prezzo;
    private String produttore;
    private Integer ageRating;

    private List<CategoriaResponseDTO> categorie;
}
