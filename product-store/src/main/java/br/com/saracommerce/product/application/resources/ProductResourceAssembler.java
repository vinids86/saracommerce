package br.com.saracommerce.product.application.resources;

import br.com.saracommerce.product.application.ProductController;
import br.com.saracommerce.product.models.Product;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 01/05/17.
 */
@Service
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, Resource> {
    private final @NonNull EntityLinks entityLinks;

    @Autowired
    public ProductResourceAssembler(EntityLinks entityLinks) {
        super(ProductController.class, Resource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource toResource(Product product) {
        final Resource<Product> resource = new Resource<>(product);
        resource.add(entityLinks.linkToSingleResource(product));
        return resource;
    }
}
