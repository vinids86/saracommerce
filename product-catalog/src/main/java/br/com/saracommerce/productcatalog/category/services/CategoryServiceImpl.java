package br.com.saracommerce.productcatalog.category.services;

import br.com.saracommerce.productcatalog.category.assemblers.CategoryORMAssembler;
import br.com.saracommerce.productcatalog.category.assemblers.CategoryVOAssembler;
import br.com.saracommerce.productcatalog.category.models.Category;
import br.com.saracommerce.productcatalog.category.repositories.CategoryRepository;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final @NonNull CategoryRepository repository;

    private final @NonNull CategoryORMAssembler ormAssembler;
    private final @NonNull CategoryVOAssembler voAssembler;


    @Override public Mono<CategoryVO> save(Mono<CategoryVO> vo) {
        final Mono<Category> categoryMono = ormAssembler.toORM(vo).flatMap(repository::save);
        return voAssembler.ormToVO(categoryMono);
    }

    @Override public Mono<CategoryVO> getById(String id) {
        return null;
    }

    @Override public Flux<CategoryVO> getAll() {
        return voAssembler.ormToVO(repository.findAll());
    }

    @Override public Mono<CategoryVO> update(String id, Mono<CategoryVO> vo) {
        return null;
    }

    @Override public Mono<Boolean> delete(String id) {
        return null;
    }
}
