package br.com.saracommerce.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vinicius on 01/05/17.
 */
public interface CRUDService<T> {

    T save(T entity);

    T getById(Long id);

    Page<T> getAll(Pageable pageable);

    void delete(Long id);
}
