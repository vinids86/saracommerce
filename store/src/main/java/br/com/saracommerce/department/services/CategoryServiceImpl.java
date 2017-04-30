package br.com.saracommerce.department.services;

import br.com.saracommerce.department.infrastructure.exceptions.CategoryNotFoundException;
import br.com.saracommerce.department.infrastructure.exceptions.DepartmentNotFoundException;
import br.com.saracommerce.department.models.Category;
import br.com.saracommerce.department.repositories.CategoryRepository;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vinicius on 30/04/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final @NonNull CategoryRepository categoryRepository;
    private final @NonNull DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Category save(Category category, Long departmentId) {
        findCategoryAndValidate(category, departmentId);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryByDepartamentIdAndCategory(Long departmentId, Long categoryId) {
        return categoryRepository.getCategoryByDepartmentIdAndId(departmentId,
                categoryId).orElseThrow(() -> new CategoryNotFoundException(departmentId, categoryId));
    }

    @Override
    @Transactional
    public void delete(Category category, Long departmentId) {
        findCategoryAndValidate(category, departmentId);
        categoryRepository.delete(category.getId());
    }

    @Override
    public Page<Category> getCategoriesByDepartment(Long id, Pageable pageable) {
        return categoryRepository.getCategoriesByDepartmentId(id, pageable);
    }

    private void findCategoryAndValidate(Category category, Long departmentId) {
        category.setDepartment(
                departmentRepository.findById(departmentId)
                        .orElseThrow(() -> new DepartmentNotFoundException(departmentId)));
    }
}
