package br.com.saracommerce.category.application.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by vinicius on 03/05/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CategoryRequest extends ResourceSupport {

    private final @NonNull String name;
}
