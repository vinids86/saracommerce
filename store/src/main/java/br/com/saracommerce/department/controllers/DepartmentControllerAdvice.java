package br.com.saracommerce.department.controllers;

import br.com.saracommerce.department.exceptions.DepartmentNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 25/04/17.
 */
@ControllerAdvice
public class DepartmentControllerAdvice {
    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(DepartmentNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}