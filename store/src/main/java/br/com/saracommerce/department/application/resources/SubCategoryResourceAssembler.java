package br.com.saracommerce.department.application.resources;

import br.com.saracommerce.department.application.SubCategoryController;
import br.com.saracommerce.department.models.SubCategory;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 30/04/17.
 */
@Service
public class SubCategoryResourceAssembler extends ResourceAssemblerSupport<SubCategory, Resource> {
    private final @NonNull EntityLinks entityLinks;

    @Autowired
    public SubCategoryResourceAssembler(EntityLinks entityLinks) {
        super(SubCategoryController.class, Resource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource toResource(SubCategory subCategory) {
        final Resource<SubCategory> subCategoryResource = new Resource<>(subCategory);
        subCategoryResource.add(entityLinks.linkToSingleResource(subCategory));
        return subCategoryResource;
    }
}
