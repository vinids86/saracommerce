package br.com.saracommerce.product.infrastructure.exceptions;

/**
 * Created by vinicius on 28/04/17.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " does not exists");
    }
}
