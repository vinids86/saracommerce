package br.com.saracommerce.product.exceptions;

import br.com.saracommerce.core.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 01/05/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " does not exists");
    }
}
