package br.com.saracommerce.productcatalog.core;

import br.com.saracommerce.productcatalog.category.models.Category;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
public interface VOAssembler<Resource extends ResourceSupport, VO extends AbstractVO, ORM extends BaseEntity> {
    Mono<VO> resourceToVO(Mono<Resource> resource);

    Mono<VO> ormToVO(Mono<ORM> orm);

    Flux<VO> ormToVO(Flux<ORM> orm);
}
