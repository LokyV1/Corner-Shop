package it.apulia.ecommerce.cornershop.domain;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class ADomain {

    @Id
    @UuidGenerator
    protected String id;
}
