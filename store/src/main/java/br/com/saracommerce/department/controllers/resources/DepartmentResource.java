package br.com.saracommerce.department.controllers.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by vinicius on 25/04/17.
 */
public class DepartmentResource extends ResourceSupport {

    private Long departmentId;

    private String name;

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
}
