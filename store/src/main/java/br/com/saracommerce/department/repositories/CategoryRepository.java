package br.com.saracommerce.department.repositories;

import br.com.saracommerce.department.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by vinicius on 30/04/17.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> getCategoriesByDepartmentId(Long id, Pageable pageable);

    Optional<Category> getCategoryByDepartmentIdAndId(Long departmentId, Long categoryId);
}
