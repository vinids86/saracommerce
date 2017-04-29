package br.com.saracommerce.product.services;

import br.com.saracommerce.product.ProductRepository;
import br.com.saracommerce.product.models.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by vinicius on 29/04/17.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final @NonNull
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
