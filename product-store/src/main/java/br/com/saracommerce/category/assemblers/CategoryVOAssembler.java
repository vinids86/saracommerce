package br.com.saracommerce.category.assemblers;

import br.com.saracommerce.category.application.resources.CategoryRequest;
import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.vo.CategoryVO;
import br.com.saracommerce.core.VOAssembler;
import org.springframework.stereotype.Service;

/**
 * Created by vinicius on 03/05/17.
 */
@Service
public class CategoryVOAssembler implements VOAssembler<CategoryRequest, CategoryVO, Category> {

    @Override
    public CategoryVO toVO(CategoryRequest request) {
        final CategoryVO categoryVO = new CategoryVO();
        categoryVO.setName(request.getName());
        return categoryVO;
    }

    @Override
    public CategoryVO toVO(Category category) {
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(category.getId());
        categoryVO.setName(category.getName());
        return categoryVO;
    }

}
