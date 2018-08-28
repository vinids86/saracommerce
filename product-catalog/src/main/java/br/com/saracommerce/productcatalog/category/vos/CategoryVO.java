package br.com.saracommerce.productcatalog.category.vos;

import br.com.saracommerce.productcatalog.core.AbstractVO;
import lombok.*;

/**
 * Created by sara on ago, 2018
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CategoryVO extends AbstractVO {

    private String id;
    private String name;
}
