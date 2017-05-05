package br.com.saracommerce.category.application.resources;

import br.com.saracommerce.category.vo.CategoryVO;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by vinicius on 03/05/17.
 */
@Data
public class CategoryResponse extends ResourceSupport {
    private final Long categoryId;
    private final String name;
    private final Long parentId;

    public CategoryResponse(CategoryVO category) {
        this.categoryId = category.getId();
        this.name = category.getName();
        this.parentId = category.getParentId();
    }
}
