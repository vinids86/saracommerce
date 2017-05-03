package br.com.saracommerce.category.exceptions;

import br.com.saracommerce.core.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 02/05/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends NotFoundException {
    public CategoryNotFoundException(Long id) {
        super("Category with id " + id + " does not exists");
    }
}
