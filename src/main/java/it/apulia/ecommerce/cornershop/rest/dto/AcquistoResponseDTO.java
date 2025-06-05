package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcquistoResponseDTO extends AResponseDTO {
    private Integer quantita;
    private Instant dataAcquisto;
    private ClienteResponseDTO cliente;
    private ProdottoResponseDTO prodotto;
}
