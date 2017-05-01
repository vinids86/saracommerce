package br.com.saracommerce.department.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 30/04/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubCategoryNotFoundException extends RuntimeException {
    public SubCategoryNotFoundException(Long departmentId, Long categoryId, Long subCategoryId) {
        super("SubCategory in Department with id " + departmentId + " and Category with id " + categoryId + " and SubCategory with id " + subCategoryId + " does not exists");
    }
}
