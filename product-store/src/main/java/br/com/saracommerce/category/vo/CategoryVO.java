package br.com.saracommerce.category.vo;

import br.com.saracommerce.core.AbstractVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by vinicius on 03/05/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CategoryVO extends AbstractVO {
    private Long id;
    private String name;
    private Long parentId;
    private Set<CategoryVO> categories;

}
