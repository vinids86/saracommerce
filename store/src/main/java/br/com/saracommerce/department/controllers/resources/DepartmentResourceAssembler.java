package br.com.saracommerce.department.controllers.resources;

import br.com.saracommerce.department.controllers.DepartmentController;
import br.com.saracommerce.department.models.Department;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource> {

    public DepartmentResourceAssembler() {
        super(DepartmentController.class, DepartmentResource.class);
    }

    @Override
    public DepartmentResource toResource(Department department) {
        final DepartmentResource resource = createResourceWithId(department.getId(), department);
        resource.setDepartmentId(department.getId());
        resource.setName(department.getName());
        return resource;
    }
}
