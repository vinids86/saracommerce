package br.com.saracommerce.productcatalog.category.assemblers;

import br.com.saracommerce.productcatalog.category.models.Category;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import br.com.saracommerce.productcatalog.core.ORMAssembler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Created by sara on ago, 2018
 */
@Component
public class CategoryORMAssembler implements ORMAssembler<CategoryVO, Category> {


    @Override public Mono<Category> toORM(Mono<CategoryVO> vo) {
        return vo.map(c -> {
            final Category category = new Category();
            category.setName(c.getName());
            return category;
        });
    }
}
