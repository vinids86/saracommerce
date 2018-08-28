package br.com.saracommerce.productcatalog.core;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService<T> {

    Mono<T> save(Mono<T> vo);

    Mono<T> getById(String id);

    Flux<T> getAll();

    Mono<T> update(String id, Mono<T> vo);

    Mono<Boolean> delete(String id);
}
