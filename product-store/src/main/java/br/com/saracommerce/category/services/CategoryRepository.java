package br.com.saracommerce.category.services;

import br.com.saracommerce.category.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vinicius on 02/05/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
