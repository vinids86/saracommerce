package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final @NonNull DepartmentRepository repository;

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Department> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Department> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
