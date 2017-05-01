package br.com.saracommerce.department.services;

import br.com.saracommerce.department.infrastructure.exceptions.CategoryNotFoundException;
import br.com.saracommerce.department.infrastructure.exceptions.DepartmentNotFoundException;
import br.com.saracommerce.department.infrastructure.exceptions.SubCategoryNotFoundException;
import br.com.saracommerce.department.models.Category;
import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.models.SubCategory;
import br.com.saracommerce.department.repositories.CategoryRepository;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import br.com.saracommerce.department.repositories.SubCategoryRepository;
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
public class SubCategoryServiceImpl implements SubCategoryService {

    private final @NonNull SubCategoryRepository subCategoryRepository;
    private final @NonNull CategoryRepository categoryRepository;
    private final @NonNull DepartmentRepository departmentRepository;

    @Override
    public SubCategory getSubCategoryByDepartamentAndCategoryAndSubCategoryId(Long departmentId, Long categoryId, Long subCategoryId) {
        categoryRepository.getCategoryByDepartmentIdAndId(departmentId, categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(departmentId, categoryId));
        return subCategoryRepository.getSubCategoryByCategoryIdAndId(categoryId, subCategoryId)
                .orElseThrow(() -> new SubCategoryNotFoundException(departmentId, categoryId, subCategoryId));
    }

    @Override
    public Page<SubCategory> getSubCategoriesByDepartmentAndCategory(Long departmentId, Long categoryId, Pageable pageable) {
        categoryRepository.getCategoryByDepartmentIdAndId(departmentId, categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(departmentId, categoryId));
        return subCategoryRepository.getSubCategoriesByCategoryId(categoryId, pageable);
    }

    @Override
    @Transactional
    public SubCategory save(SubCategory subCategory, Long categoryId, Long departmentId) {
        final Category category = findCategoryAndValidate(categoryId, departmentId);
        category.setDepartment(findDepartmentAndValidate(departmentId));
        subCategory.setCategory(category);
        return subCategoryRepository.save(subCategory);
    }

    @Override
    @Transactional
    public void delete(SubCategory subCategory, Long categoryId, Long departmentId) {
        final Category category = findCategoryAndValidate(categoryId, departmentId);
        category.setDepartment(findDepartmentAndValidate(departmentId));
        subCategory.setCategory(category);
        subCategoryRepository.delete(subCategory.getId());
    }

    private Category findCategoryAndValidate(Long categoryId, Long departmentId) {
        return categoryRepository.getCategoryByDepartmentIdAndId(departmentId, categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(departmentId, categoryId));
    }

    private Department findDepartmentAndValidate(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException(departmentId));
    }
}
