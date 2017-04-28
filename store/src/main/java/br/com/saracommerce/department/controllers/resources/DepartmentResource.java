package br.com.saracommerce.department.controllers.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by vinicius on 25/04/17.
 */
public class DepartmentResource extends ResourceSupport {

    private Long departmentId;

    private String name;

    private List<CategoryResource> categories;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryResource> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryResource> categories) {
        this.categories = categories;
    }

}
