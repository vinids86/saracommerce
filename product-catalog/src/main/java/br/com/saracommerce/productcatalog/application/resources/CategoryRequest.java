package br.com.saracommerce.productcatalog.application.resources;

import br.com.saracommerce.productcatalog.core.ResourceSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by sara on ago, 2018
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CategoryRequest extends ResourceSupport {

    private final @NonNull String name;
}

