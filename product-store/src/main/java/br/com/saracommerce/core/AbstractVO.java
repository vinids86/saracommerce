package br.com.saracommerce.core;

import org.springframework.hateoas.Identifiable;

/**
 * Created by vinicius on 03/05/17.
 */
public class AbstractVO implements Identifiable<Long> {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }
}
