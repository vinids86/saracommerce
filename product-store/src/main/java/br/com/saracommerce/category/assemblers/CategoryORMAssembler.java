package br.com.saracommerce.category.assemblers;

import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.vo.CategoryVO;
import br.com.saracommerce.core.ORMAssembler;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 03/05/17.
 */
@Service
public class CategoryORMAssembler implements ORMAssembler<CategoryVO, Category> {
    @Override
    public Category toORM(CategoryVO categoryVO) {
        final Category category = new Category();
        category.setName(categoryVO.getName());
        return category;
    }
}
