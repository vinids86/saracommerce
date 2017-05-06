package br.com.saracommerce.core;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by vinicius on 03/05/17.
 */
public interface VOAssembler<Resource extends ResourceSupport, VO extends AbstractVO, ORM extends AbstractEntity> {
    VO toVO(Resource resource);

    VO toVO(ORM orm);
}
