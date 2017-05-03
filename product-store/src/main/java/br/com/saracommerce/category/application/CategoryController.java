package br.com.saracommerce.category.application;

import br.com.saracommerce.category.application.resources.CategoryResourceAssembler;
import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.services.CategoryService;
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
 * Created by vinicius on 02/05/17.
 */

@RestController
@ExposesResourceFor(Category.class)
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final static Logger logger = Logger.getLogger(CategoryController.class);

    private final @NonNull CategoryService categoryService;
    private final @NonNull CategoryResourceAssembler categoryResourceAssembler;
    private final @NonNull PagedResourcesAssembler<Category> pageAssembler;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource> createCategory(@RequestBody Category category) {
        final Category categorySaved = categoryService.save(category);
        final Resource resource = categoryResourceAssembler.toResource(categorySaved);
        logger.info("Created::" + categorySaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> retrieveCategory(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        final Resource resource = categoryResourceAssembler.toResource(category);
        logger.debug("Found Category::" + category);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> listAllCategorys(Pageable pageable) {
        final Page<Category> categories = categoryService.getAll(pageable);
        final PagedResources<Resource> resources = pageAssembler.toResource(categories, categoryResourceAssembler);
        logger.debug("Found " + categories.getTotalElements() + " departments");
        logger.debug(categories.getContent());
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Resource> updateCategory(@RequestBody Category category) {
        categoryService.getById(category.getId());
        final Category categorySave = categoryService.save(category);
        final Resource resource = categoryResourceAssembler.toResource(categorySave);
        logger.info("Updated::" + categorySave);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource> deleteCategory(@PathVariable Long id) {
        categoryService.getById(id);
        categoryService.delete(id);
        logger.info("Category with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }

}