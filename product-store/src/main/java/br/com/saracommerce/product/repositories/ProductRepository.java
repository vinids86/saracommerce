package br.com.saracommerce.product.repositories;

import br.com.saracommerce.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vinicius on 01/05/17.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
