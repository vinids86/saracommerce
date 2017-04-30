package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.Category;
import br.com.saracommerce.department.repositories.CategoryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by vinicius on 30/04/17.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final @NonNull CategoryRepository repository;

    @Override
    public Category save(Category entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }


    @Override
    public Page<Category> getCategoriesByDepartment(Long id, Pageable pageable) {
        return repository.getCategoriesByDepartmentId(id, pageable);
    }
}
