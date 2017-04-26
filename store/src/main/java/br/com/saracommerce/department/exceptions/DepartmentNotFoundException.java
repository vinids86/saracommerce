package br.com.saracommerce.department.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 25/04/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Department with id " + id + " does not exists");
    }
}
