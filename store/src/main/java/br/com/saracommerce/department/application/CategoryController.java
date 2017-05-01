package br.com.saracommerce.department.application;

import br.com.saracommerce.department.application.resources.CategoryResourceAssembler;
import br.com.saracommerce.department.models.Category;
import br.com.saracommerce.department.services.CategoryService;
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
 * Created by vinicius on 30/04/17.
 */

@RestController
@ExposesResourceFor(Category.class)
@RequiredArgsConstructor
@RequestMapping("/departments")
public class CategoryController {

    private final static Logger logger = Logger.getLogger(CategoryController.class);

    private final @NonNull CategoryResourceAssembler categoryResourceAssembler;
    private final @NonNull PagedResourcesAssembler<Category> pageAssembler;
    private final @NonNull CategoryService service;

    @RequestMapping(value = "/{departmentId}/categories", method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> getCategoriesByDepartment(@PathVariable Long departmentId, Pageable pageable) {
        final Page<Category> categories = service.getCategoriesByDepartment(departmentId, pageable);
        final PagedResources<Resource> resources = pageAssembler.toResource(categories, categoryResourceAssembler);
        logger.debug("Found " + categories.getTotalElements() + " categories");
        logger.debug(categories);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getCategoryByDepartment(@PathVariable Long departmentId, @PathVariable("categoryId") Long categoryId) {
        Category category = service.getCategoryByDepartamentAndCategoryId(departmentId, categoryId);
        final Resource resource = categoryResourceAssembler.toResource(category);
        logger.debug("Found Category::" + category);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "/{departmentId}/categories", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCategory(@PathVariable Long departmentId, @RequestBody Category category, Pageable pageable) {
        final Category categorySaved = service.save(category, departmentId);
        logger.info("Added::" + categorySaved);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable Long departmentId, @PathVariable("categoryId") Long categoryId) {
        final Category category = service.getCategoryByDepartamentAndCategoryId(departmentId, categoryId);
        service.delete(category, departmentId);
        logger.debug("Department with categoryId " + categoryId + " deleted");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{departmentId}/categories", method = RequestMethod.POST)
    public ResponseEntity<Resource> addCategory(@PathVariable("departmentId") Long departmentId, @RequestBody Category category) {
        final Category categorySaved = service.save(category, departmentId);
        final Resource resource = categoryResourceAssembler.toResource(categorySaved);
        logger.info("Added::" + categorySaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }
}
