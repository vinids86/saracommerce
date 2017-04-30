package br.com.saracommerce.department.repositories;

import br.com.saracommerce.department.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by vinicius on 30/04/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

    Page<Category> getCategoriesByDepartmentId(Long id, Pageable pageable);
}
