package br.com.saracommerce.department.controllers.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by vinicius on 28/04/17.
 */
public class SubCategoryResource extends ResourceSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
