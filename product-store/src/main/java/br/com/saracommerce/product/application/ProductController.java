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
 * Created by vinicius on 01/05/17.
 */

@RestController
@ExposesResourceFor(Product.class)
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final static Logger logger = Logger.getLogger(ProductController.class);

    private final @NonNull ProductService productService;
    private final @NonNull ProductResourceAssembler productResourceAssembler;
    private final @NonNull PagedResourcesAssembler<Product> pageAssembler;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource> createProduct(@RequestBody Product product) {
        final Product productSaved = productService.save(product);
        final Resource resource = productResourceAssembler.toResource(productSaved);
        logger.info("Created::" + productSaved);
        return ResponseEntity.created(URI.create(resource.getLink("self").getHref())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> retrieveProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        final Resource resource = productResourceAssembler.toResource(product);
        logger.debug("Found Product::" + product);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<Resource>> listAllProducts(Pageable pageable) {
        final Page<Product> products = productService.getAll(pageable);
        final PagedResources<Resource> resources = pageAssembler.toResource(products, productResourceAssembler);
        logger.debug("Found " + products.getTotalElements() + " departments");
        logger.debug(products.getContent());
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Resource> updateProduct(@RequestBody Product product) {
        productService.getById(product.getId());
        final Product productSave = productService.save(product);
        final Resource resource = productResourceAssembler.toResource(productSave);
        logger.info("Updated::" + productSave);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource> deleteProduct(@PathVariable Long id) {
        productService.getById(id);
        productService.delete(id);
        logger.info("Product with id " + id + " deleted");
        return ResponseEntity.ok().build();
    }

}
