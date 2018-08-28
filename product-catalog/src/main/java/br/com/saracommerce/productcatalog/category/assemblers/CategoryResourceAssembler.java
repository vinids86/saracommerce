package br.com.saracommerce.productcatalog.category.assemblers;

import br.com.saracommerce.productcatalog.application.resources.CategoryResponse;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import br.com.saracommerce.productcatalog.core.ResourceAssembler;
import br.com.saracommerce.productcatalog.core.ResourceSupport;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
@Component
public class CategoryResourceAssembler implements ResourceAssembler<CategoryVO, CategoryResponse> {

    @Override public Mono<CategoryResponse> toResource(Mono<CategoryVO> vo) {
        return vo.map(c -> new CategoryResponse(c.getName()));
    }

    @Override public Flux<CategoryResponse> toResource(Flux<CategoryVO> vos) {
        return vos.map(c -> new CategoryResponse(c.getName()));
    }
}
