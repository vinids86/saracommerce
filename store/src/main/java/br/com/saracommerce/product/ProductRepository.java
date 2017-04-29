package br.com.saracommerce.product;

import br.com.saracommerce.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vinicius on 28/04/17.
 */
@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(Long id);
}
