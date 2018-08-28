package br.com.saracommerce.productcatalog.application.resources;

import br.com.saracommerce.productcatalog.core.ResourceSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Created by sara on ago, 2018
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryResponse extends ResourceSupport {

    private final @NonNull String name;
}
