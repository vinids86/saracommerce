package br.com.saracommerce.department.controllers;

import br.com.saracommerce.department.controllers.resources.DepartmentResource;
import br.com.saracommerce.department.controllers.resources.DepartmentResourceAssembler;
import br.com.saracommerce.department.exceptions.DepartmentNotFoundException;
import br.com.saracommerce.department.models.Department;
import br.com.saracommerce.department.services.DepartmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by vinicius on 22/04/17.
 */

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private final static Logger logger = Logger.getLogger(DepartmentController.class);


    private final DepartmentService service;
    private DepartmentResourceAssembler departmentResourceAssembler;
    private PagedResourcesAssembler<Department> pageAssembler;

    @Autowired
    public DepartmentController(DepartmentService service, DepartmentResourceAssembler departmentResourceAssembler, PagedResourcesAssembler<Department> pageAssembler) {
        this.service = service;
        this.departmentResourceAssembler = departmentResourceAssembler;
        this.pageAssembler = pageAssembler;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DepartmentResource> addDepartment(@RequestBody Department department) {
        final DepartmentResource resource = departmentResourceAssembler.toResource(service.save(department));
        logger.info("Added::" + resource);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateDepartment(@RequestBody Department department, Pageable pageable) {
        validateDepartment(department.getId());
        service.save(department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentResource> getDepartment(@PathVariable("id") Long id) {
        Department department = validateDepartment(id);
        final DepartmentResource resource = departmentResourceAssembler.toResource(department);
        logger.debug("Found Department::" + resource);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<DepartmentResource>> getAllDepartments(Pageable pageable) {
        final Page<Department> departments = service.getAll(pageable);

        final PagedResources<DepartmentResource> resources = pageAssembler.toResource(departments, departmentResourceAssembler);
        logger.debug("Found " + departments.getTotalElements() + " departments");
        logger.debug(resources);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id) {
        validateDepartment(id);
        service.delete(id);
        logger.debug("Department with id " + id + " deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Department validateDepartment(final Long id) {
        return service.getById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }
}
