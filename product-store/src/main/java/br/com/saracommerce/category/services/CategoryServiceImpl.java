package br.com.saracommerce.category.services;

import br.com.saracommerce.category.assemblers.CategoryORMAssembler;
import br.com.saracommerce.category.assemblers.CategoryVOAssembler;
import br.com.saracommerce.category.exceptions.CategoryNotFoundException;
import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.vo.CategoryVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by vinicius on 02/05/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final @NonNull CategoryRepository categoryRepository;

    private final @NonNull CategoryORMAssembler categoryORMAssembler;
    private final @NonNull CategoryVOAssembler categoryVOAssembler;

    @Override
    @Transactional
    public CategoryVO save(CategoryVO category) {
        if (category.getParentId() != null) {
            final CategoryVO parent = this.getById(category.getParentId());
            final Set<CategoryVO> existingCategories = parent.getCategories();
            existingCategories.add(category);
            parent.setCategories(existingCategories);
            return categoryVOAssembler.toVO(categoryRepository.save(categoryORMAssembler.toORM(parent)));
        } else
            return categoryVOAssembler.toVO(categoryRepository.save(categoryORMAssembler.toORM(category)));
    }

    @Override
    public CategoryVO getById(Long id) {
        return categoryVOAssembler.toVO(Optional.ofNullable(categoryRepository.findOne(id))
                .orElseThrow(() -> new CategoryNotFoundException(id)));
    }

    @Override
    public Page<CategoryVO> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryVOAssembler::toVO);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    @Transactional
    public CategoryVO update(Long id, CategoryVO vo) {
        final Category category = categoryRepository.findOne(id);
        category.setName(vo.getName());
        category.setParentId(vo.getParentId());
        final Set<CategoryVO> categoryVOS = vo.getCategories();

        Set<Category> categories = new HashSet<>();
        if (categoryVOS != null)
            categoryVOS.forEach(categoryVO -> categories.add(categoryORMAssembler.toORM(categoryVO)));
        else
            category.setCategories(null);

        category.setCategories(categories);
        return categoryVOAssembler.toVO(categoryRepository.save(category));
    }
}
