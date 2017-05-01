package br.com.saracommerce.department.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 30/04/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long departmentId, Long categoryId) {
        super("Category in Department with id " + departmentId + " and Category with id " + categoryId + " does not exists");
    }
}

