package br.com.saracommerce.product.services;

import br.com.saracommerce.product.infrastructure.exceptions.ProductNotFoundException;
import br.com.saracommerce.product.models.Product;
import br.com.saracommerce.product.repositories.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vinicius on 29/04/17.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final @NonNull ProductRepository repository;

    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }
}
