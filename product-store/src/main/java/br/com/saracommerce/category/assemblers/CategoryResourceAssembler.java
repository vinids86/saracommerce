package br.com.saracommerce.category.assemblers;

import br.com.saracommerce.category.application.CategoryController;
import br.com.saracommerce.category.application.resources.CategoryResponse;
import br.com.saracommerce.category.vo.CategoryVO;
import br.com.saracommerce.core.ResourceAssemblerSupportStore;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 02/05/17.
 */
@Service
public class CategoryResourceAssembler extends ResourceAssemblerSupportStore<CategoryVO, CategoryResponse> {

    private final @NonNull EntityLinks entityLinks;

    @Autowired
    public CategoryResourceAssembler(EntityLinks entityLinks) {
        super(CategoryController.class, CategoryResponse.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public CategoryResponse toResource(CategoryVO category) {
        final CategoryResponse resource = new CategoryResponse(category);
        resource.add(entityLinks.linkToSingleResource(category));
        return resource;
    }

}
