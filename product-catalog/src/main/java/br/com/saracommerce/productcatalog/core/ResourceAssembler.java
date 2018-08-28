package br.com.saracommerce.productcatalog.core;

import br.com.saracommerce.productcatalog.application.resources.CategoryResponse;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
public interface ResourceAssembler<VO extends AbstractVO, Resource extends ResourceSupport> {
    Mono<Resource> toResource(Mono<VO> vo);

    Flux<Resource> toResource(Flux<VO> vos);
}
