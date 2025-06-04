package it.apulia.ecommerce.cornershop.service;

import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public abstract class AService<ID, ENTITY, DTO> {

    private final JpaRepository<ENTITY, ID> repo;

    protected abstract ENTITY map(DTO dto);

    protected abstract ENTITY map(ENTITY entity, DTO dto);

    protected ENTITY save(DTO dto) throws Exception {
        ENTITY entity = map(dto);
        return this.repo.saveAndFlush(entity);
    }

    protected ENTITY update(ID id, DTO dto) throws Exception {
        ENTITY entity = this.repo.findById(id)
                .orElseThrow(
                    () -> {
                        return new EntityNotFoundException(
                            String.format("ID not found: %s", id.toString())
                        );
                    }
                );
        ENTITY entityUpdated = map(entity, dto);
        return this.repo.saveAndFlush(entityUpdated);
    }

    protected ENTITY getById(ID id) throws Exception {
        return this.repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID not found: %s", id.toString())));
    }

    protected List<ENTITY> getAll(Example<ENTITY> criterias) {
        if(Objects.nonNull(criterias)){
            return this.repo.findAll(criterias);
        }else{
            return this.repo.findAll();
        }
    }

    protected void deleteById(ID id) {
        ENTITY entity = this.repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID not found: %s", id.toString())));
        this.repo.delete(entity);
    }

}