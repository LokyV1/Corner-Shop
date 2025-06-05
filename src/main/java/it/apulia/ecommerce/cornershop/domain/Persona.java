package it.apulia.ecommerce.cornershop.domain;

import java.time.Instant;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona extends ADomain {
    protected String nome;
    protected String cognome;
    protected Instant dataNascita;
}
