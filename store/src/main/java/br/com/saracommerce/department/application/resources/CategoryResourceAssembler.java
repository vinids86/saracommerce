package br.com.saracommerce.department.application.resources;

import br.com.saracommerce.department.application.CategoryController;
import br.com.saracommerce.department.models.Category;
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
public class CategoryResourceAssembler extends ResourceAssemblerSupport<Category, Resource> {

    private final @NonNull EntityLinks entityLinks;

    @Autowired
    public CategoryResourceAssembler(EntityLinks entityLinks) {
        super(CategoryController.class, Resource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource toResource(Category category) {
        final Resource<Category> categoryResource = new Resource<>(category);
        categoryResource.add(entityLinks.linkToSingleResource(category));
        return categoryResource;
    }
}
