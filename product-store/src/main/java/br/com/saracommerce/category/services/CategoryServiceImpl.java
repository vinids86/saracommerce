package br.com.saracommerce.category.services;

import br.com.saracommerce.category.exceptions.CategoryNotFoundException;
import br.com.saracommerce.category.models.Category;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Category save(Category category) {
        if (category.getParentId() != null) {
            final Category parent = this.getById(category.getParentId());
            final Set<Category> existingCategories = parent.getCategories();
            existingCategories.add(category);
            parent.setCategories(existingCategories);
            return categoryRepository.save(parent);
        } else
            return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return Optional.ofNullable(categoryRepository.findOne(id)).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
