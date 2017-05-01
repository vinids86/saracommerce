package br.com.saracommerce.department.services;

import br.com.saracommerce.department.models.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vinicius on 30/04/17.
 */
public interface SubCategoryService {
    Page<SubCategory> getSubCategoriesByDepartmentAndCategory(Long categoryId, Long departmentId, Pageable pageable);

    SubCategory getSubCategoryByDepartamentAndCategoryAndSubCategoryId(Long departmentId, Long categoryId, Long subCategoryId);

    SubCategory save(SubCategory subCategory, Long categoryId, Long departmentId);

    void delete(SubCategory subCategory, Long categoryId, Long departmentId);
}
