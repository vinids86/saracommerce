package br.com.saracommerce.product.services;

import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.category.services.CategoryRepository;
import br.com.saracommerce.product.exceptions.ProductNotFoundException;
import br.com.saracommerce.product.models.Product;
import br.com.saracommerce.product.repositories.ProductRepository;
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
 * Created by vinicius on 01/05/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final @NonNull ProductRepository productRepository;
    private final @NonNull CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        product.getCategories().forEach(category -> categoryRepository.findOne(category.getId()));

        Set<Category> categories = new HashSet<>();
        for(Category category : product.getCategories()) {
            categories.add(categoryRepository.findOne(category.getId()));
        }
        product.setCategories(categories);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return Optional.ofNullable(productRepository.findOne(id))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product update(Long id, Product vo) {
        return null;
    }
}
