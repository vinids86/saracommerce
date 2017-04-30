package br.com.saracommerce.product.application;

import br.com.saracommerce.product.application.resources.ProductResourceAssembler;
import br.com.saracommerce.product.models.Product;
import br.com.saracommerce.product.services.ProductService;
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
 * Created by vinicius on 28/04/17.
 */

@RestController
@ExposesResourceFor(Product.class)
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final static Logger logger = Logger.getLogger(ProductController.class);

    private final @NonNull ProductService service;
    private final @NonNull ProductResourceAssembler productResourceAssembler;
    private final @NonNull PagedResourcesAssembler<Product> pageAssembler;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource> addProduct(@RequestBody Product product) {
        final Product productSave = service.save(product);
        final Resource resource = productResourceAssembler.toResource(productSave);
        logger.info("Added::" + productSave);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@RequestBody Product product, Pageable pageable) {
        service.getById(product.getId());
        service.save(product);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getProduct(@PathVariable("id") Long id) {
        Product product = service.getById(id);
        final Resource resource = productResourceAssembler.toResource(product);
        logger.debug("Found Product::" + resource);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> getAllProducts(Pageable pageable) {
        final Page<Product> products = service.getAll(pageable);

        final PagedResources<Resource> resources = pageAssembler.toResource(products, productResourceAssembler);
        logger.debug("Found " + products.getTotalElements() + " products");
        logger.debug(resources);
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        service.getById(id);
        service.delete(id);
        logger.debug("Product with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }
}