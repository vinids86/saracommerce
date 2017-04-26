package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by vinicius on 25/04/17.
 */
public interface CRUDService<E> {

    Department save(E entity);

    Optional<Department> getById(Long id);

    Page<Department> getAll(Pageable pageable);

    void delete(Long id);
}
