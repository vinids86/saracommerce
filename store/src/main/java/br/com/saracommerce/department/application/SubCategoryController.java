package br.com.saracommerce.department.application;

import br.com.saracommerce.department.application.resources.SubCategoryResourceAssembler;
import br.com.saracommerce.department.models.SubCategory;
import br.com.saracommerce.department.services.SubCategoryService;
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
@ExposesResourceFor(SubCategory.class)
@RequiredArgsConstructor
@RequestMapping("/departments")
public class SubCategoryController {

    private final static Logger logger = Logger.getLogger(CategoryController.class);

    private final @NonNull SubCategoryResourceAssembler subCategoryResourceAssembler;
    private final @NonNull PagedResourcesAssembler<SubCategory> pageAssembler;
    private final @NonNull SubCategoryService service;

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}/subcategories", method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> getSubCategoriesByDepartmentAndCategory(
            @PathVariable Long departmentId,
            @PathVariable Long categoryId, Pageable pageable) {
        final Page<SubCategory> subCategories = service.getSubCategoriesByDepartmentAndCategory(departmentId, categoryId, pageable);
        final PagedResources<Resource> resources = pageAssembler.toResource(subCategories, subCategoryResourceAssembler);
        logger.debug("Found " + subCategories.getTotalElements() + " subCategories");
        logger.debug(subCategories);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}/subcategories/{subCategoryId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getSubCategoryByDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long categoryId,
            @PathVariable Long subCategoryId) {
        SubCategory subCategory = service.getSubCategoryByDepartamentAndCategoryAndSubCategoryId(departmentId, categoryId, subCategoryId);
        final Resource resource = subCategoryResourceAssembler.toResource(subCategory);
        logger.debug("Found Category::" + subCategory);

        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}/subcategories/{subCategoryId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSubCategory(
            @PathVariable Long departmentId,
            @PathVariable Long categoryId,
            @PathVariable Long subCategoryId,
            @RequestBody SubCategory subCategory, Pageable pageable) {

        service.getSubCategoryByDepartamentAndCategoryAndSubCategoryId(departmentId, categoryId, subCategoryId);
        final SubCategory subCategorySaved = service.save(subCategory, categoryId, departmentId);
        logger.info("Added::" + subCategorySaved);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}/subcategories/{subCategoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubCategory(
            @PathVariable("departmentId") Long departmentId,
            @PathVariable("categoryId") Long categoryId,
            @PathVariable Long subCategoryId) {
        final SubCategory subCategory = service.getSubCategoryByDepartamentAndCategoryAndSubCategoryId(departmentId, categoryId, subCategoryId);
        service.delete(subCategory, categoryId, departmentId);
        logger.debug("Department with categoryId " + categoryId + " deleted");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{departmentId}/categories/{categoryId}/subcategories", method = RequestMethod.POST)
    public ResponseEntity<Resource> addSubCategory(
            @PathVariable Long departmentId,
            @PathVariable Long categoryId,
            @RequestBody SubCategory subCategory) {
        final SubCategory subCategorySaved = service.save(subCategory, categoryId, departmentId);
        final Resource resource = subCategoryResourceAssembler.toResource(subCategorySaved);
        logger.info("Added::" + subCategorySaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }
}
