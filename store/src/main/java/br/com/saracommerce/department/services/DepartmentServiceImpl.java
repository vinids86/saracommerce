package br.com.saracommerce.department.services;

import br.com.saracommerce.department.infrastructure.exceptions.DepartmentNotFoundException;
import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final @NonNull DepartmentRepository repository;

    @Override
    @Transactional
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public Department getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Override
    public Page<Department> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }
}
