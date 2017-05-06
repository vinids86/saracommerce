package br.com.saracommerce.core;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by vinicius on 03/05/17.
 */
public abstract class ResourceAssemblerSupportStore<T, D extends ResourceSupport> extends ResourceAssemblerSupport<T, D> implements ResourceAssembler<T, D> {


    public ResourceAssemblerSupportStore(Class controllerClass, Class resourceType) {
        super(controllerClass, resourceType);
    }
}
