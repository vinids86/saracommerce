package br.com.saracommerce.core;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vinicius on 02/05/17.
 */

@ControllerAdvice
public class ProductControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(NotFoundException o_0) {
        return new VndErrors("error", o_0.getMessage());
    }
}
