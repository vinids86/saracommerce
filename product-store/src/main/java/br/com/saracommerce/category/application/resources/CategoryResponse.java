package br.com.saracommerce.category.application.resources;

import br.com.saracommerce.category.vo.CategoryVO;
import lombok.Data;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.Assert;

/**
 * Created by vinicius on 03/05/17.
 */
@Data
@ToString(callSuper = true)
public class CategoryResponse extends ResourceSupport {
    private final Long categoryId;
    private final String name;
    private final Long parentId;

    public CategoryResponse(CategoryVO vo) {
        Assert.notNull(vo, "The given vo must not be null!");
        this.categoryId = vo.getId();
        this.name = vo.getName();
        this.parentId = vo.getParentId();
    }
}
