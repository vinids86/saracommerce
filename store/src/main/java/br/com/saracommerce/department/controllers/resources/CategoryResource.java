package br.com.saracommerce.department.controllers.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by vinicius on 28/04/17.
 */
public class CategoryResource extends ResourceSupport {

    private String name;

    private List<SubCategoryResource> subCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategoryResource> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryResource> subCategories) {
        this.subCategories = subCategories;
    }
}
