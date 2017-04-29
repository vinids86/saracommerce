package br.com.saracommerce.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by vinicius on 29/04/17.
 */
public interface CRUDService<E> {

    E save(E entity);

    Optional<E> getById(Long id);

    Page<E> getAll(Pageable pageable);

    void delete(Long id);
}

