package it.apulia.ecommerce.cornershop.rest.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcquistoDTO {
    private Integer quantita;
    private Instant dataAcquisto;
    private String clienteId;
    private String prodottoId;
}
