package br.com.saracommerce.department.services;

import br.com.saracommerce.core.service.CRUDService;
import br.com.saracommerce.department.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vinicius on 30/04/17.
 */
public interface CategoryService extends CRUDService<Category> {
    Page<Category> getCategoriesByDepartment(Long id, Pageable pageable);
}
