package br.com.saracommerce.core;

import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.vo.CategoryVO;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

/**
 * Created by vinicius on 03/05/17.
 */
public interface VOAssembler<Resource extends ResourceSupport, VO extends AbstractVO, ORM extends AbstractEntity> {
    VO toVO(Resource resource);

    VO toVO(ORM orm);
}
