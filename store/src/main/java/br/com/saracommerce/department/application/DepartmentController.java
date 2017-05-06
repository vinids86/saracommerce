package br.com.saracommerce.department.application;

import br.com.saracommerce.department.application.resources.DepartmentResourceAssembler;
import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.services.DepartmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by vinicius on 22/04/17.
 */

@RestController
@ExposesResourceFor(Department.class)
@RequiredArgsConstructor
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final static Logger logger = Logger.getLogger(DepartmentController.class);

    private final @NonNull DepartmentService service;
    private final @NonNull DepartmentResourceAssembler departmentResourceAssembler;
    private final @NonNull PagedResourcesAssembler<Department> pageAssembler;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource> addDepartment(@RequestBody Department department) {
        final Department departmentSaved = service.save(department);
        final Resource resource = departmentResourceAssembler.toResource(departmentSaved);
        logger.info("Added::" + departmentSaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateDepartment(@RequestBody Department department) {
        service.getById(department.getId());
        final Department departmentSaved = service.save(department);
        logger.info("Added::" + departmentSaved);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getDepartment(@PathVariable("id") Long id) {
        Department department = service.getById(id);
        final Resource resource = departmentResourceAssembler.toResource(department);
        logger.debug("Found Department::" + department);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> getAllDepartments(Pageable pageable) {
        final Page<Department> departments = service.getAll(pageable);
        final PagedResources<Resource> resources = pageAssembler.toResource(departments, departmentResourceAssembler);
        logger.debug("Found " + departments.getTotalElements() + " departments");
        logger.debug(departments);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id) {
        service.getById(id);
        service.delete(id);
        logger.debug("Department with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }
}
