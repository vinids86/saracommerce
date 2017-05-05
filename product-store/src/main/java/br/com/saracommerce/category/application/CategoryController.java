package br.com.saracommerce.category.application;

import br.com.saracommerce.category.assemblers.CategoryResourceAssembler;
import br.com.saracommerce.category.assemblers.CategoryVOAssembler;
import br.com.saracommerce.category.application.resources.CategoryRequest;
import br.com.saracommerce.category.application.resources.CategoryResponse;
import br.com.saracommerce.category.services.CategoryService;
import br.com.saracommerce.category.vo.CategoryVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
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
@ExposesResourceFor(CategoryVO.class)
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final static Logger logger = Logger.getLogger(CategoryController.class);

    private final @NonNull CategoryService categoryService;

    private final @NonNull CategoryResourceAssembler categoryResourceAssembler;
    private final @NonNull CategoryVOAssembler categoryVOAssembler;
    private final @NonNull PagedResourcesAssembler<CategoryVO> pageAssembler;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        final CategoryVO categorySaved = categoryService.save(categoryVOAssembler.toVO(categoryRequest));
        final CategoryResponse resource = categoryResourceAssembler.toResource(categorySaved);
        logger.info("Created::" + categorySaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> retrieveCategory(@PathVariable Long id) {
        CategoryVO category = categoryService.getById(id);
        final CategoryResponse resource = categoryResourceAssembler.toResource(category);
        logger.debug("Found Category::" + category);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<CategoryResponse>> listAllCategories(Pageable pageable) {
        final Page<CategoryVO> categories = categoryService.getAll(pageable);
        final PagedResources<CategoryResponse> resources = pageAssembler.toResource(categories, categoryResourceAssembler);
        logger.debug("Found " + categories.getTotalElements() + " departments");
        logger.debug(categories.getContent());
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest category) {
        final CategoryVO categorySave = categoryService.update(id, categoryVOAssembler.toVO(category));
        final CategoryResponse categoryResponse = categoryResourceAssembler.toResource(categorySave);
        logger.info("Updated::" + categorySave);
        return ResponseEntity.ok(categoryResponse);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.getById(id);
        categoryService.delete(id);
        logger.info("Category with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }

}