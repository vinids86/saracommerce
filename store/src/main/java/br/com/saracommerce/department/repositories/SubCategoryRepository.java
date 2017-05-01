package br.com.saracommerce.department.repositories;

import br.com.saracommerce.department.models.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by vinicius on 30/04/17.
 */
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> getSubCategoryByCategoryIdAndId(Long categoryId, Long subCategoryId);

    Page<SubCategory> getSubCategoriesByCategoryId(Long categoryId, Pageable pageable);
}
