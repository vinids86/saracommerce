package br.com.saracommerce.productcatalog.core;

import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
public interface ORMAssembler<VO extends AbstractVO, ORM> {
    Mono<ORM> toORM(Mono<VO> vo);
}
