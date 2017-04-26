package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.repository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public Optional<Department> getById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public Page<Department> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
