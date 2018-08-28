package br.com.saracommerce.productcatalog.category.assemblers;

import br.com.saracommerce.productcatalog.application.resources.CategoryRequest;
import br.com.saracommerce.productcatalog.category.models.Category;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import br.com.saracommerce.productcatalog.core.VOAssembler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
@Component
public class CategoryVOAssembler implements VOAssembler<CategoryRequest, CategoryVO, Category> {
//TODO interface map to resource

    @Override public Mono<CategoryVO> resourceToVO(Mono<CategoryRequest> resource) {
        return resource.map(c -> {
            final CategoryVO categoryVO = new CategoryVO();
            categoryVO.setName(c.getName());
            return categoryVO;
        });
    }

    @Override public Mono<CategoryVO> ormToVO(Mono<Category> orm) {
        return orm.map(c -> {
            final CategoryVO categoryVO = new CategoryVO();
            categoryVO.setName(c.getName());
            return categoryVO;
        });
    }

    @Override public Flux<CategoryVO> ormToVO(Flux<Category> orm) {
        return orm.map(c -> {
            final CategoryVO categoryVO = new CategoryVO();
            categoryVO.setName(c.getName());
            return categoryVO;
        });
    }
}
