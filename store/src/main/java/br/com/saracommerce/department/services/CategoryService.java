package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vinicius on 30/04/17.
 */
public interface CategoryService {
    Page<Category> getCategoriesByDepartment(Long id, Pageable pageable);

    Category save(Category category, Long departmentId);

    Category getCategoryByDepartamentIdAndCategory(Long departmentId, Long categoryId);

    void delete(Category category, Long departmentId);
}
