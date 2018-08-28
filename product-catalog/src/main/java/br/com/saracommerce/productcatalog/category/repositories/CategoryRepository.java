package br.com.saracommerce.productcatalog.category.repositories;

import br.com.saracommerce.productcatalog.category.models.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    Flux<Category> findByName(String name);
}
