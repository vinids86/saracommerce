package br.com.saracommerce.department.application.resources;

import br.com.saracommerce.department.application.DepartmentController;
import br.com.saracommerce.department.models.Department;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, Resource> {

    private final @NonNull
    EntityLinks entityLinks;

    @Autowired
    public DepartmentResourceAssembler(EntityLinks entityLinks) {
        super(DepartmentController.class, Resource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource<Department> toResource(Department department) {
        final Resource<Department> departmentResource = new Resource<>(department);
        departmentResource.add(entityLinks.linkToSingleResource(department));
        return departmentResource;
    }
}
