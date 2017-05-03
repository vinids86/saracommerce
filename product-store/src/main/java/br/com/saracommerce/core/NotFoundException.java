package br.com.saracommerce.core;

/**
 * Created by vinicius on 02/05/17.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
