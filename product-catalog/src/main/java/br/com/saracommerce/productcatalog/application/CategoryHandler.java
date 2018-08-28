package br.com.saracommerce.productcatalog.application;

import br.com.saracommerce.productcatalog.application.resources.CategoryRequest;
import br.com.saracommerce.productcatalog.application.resources.CategoryResponse;
import br.com.saracommerce.productcatalog.category.assemblers.CategoryResourceAssembler;
import br.com.saracommerce.productcatalog.category.assemblers.CategoryVOAssembler;
import br.com.saracommerce.productcatalog.category.services.CategoryService;
import br.com.saracommerce.productcatalog.category.vos.CategoryVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by sara on ago, 2018
 */
@Component
@RequiredArgsConstructor
public class CategoryHandler {

    private final static Logger logger = LoggerFactory.getLogger(CategoryHandler.class);

    private final @NonNull CategoryService service;
    private final @NonNull CategoryResourceAssembler assembler;
    private final @NonNull CategoryVOAssembler ormAssembler;

    public Mono<ServerResponse> createCategory(ServerRequest request) {

        final Mono<CategoryVO> vo = ormAssembler.resourceToVO(request.bodyToMono(CategoryRequest.class));
        final Mono<CategoryVO> save = service.save(vo);
        final Mono<CategoryResponse> resource = assembler.toResource(save);

        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(resource, CategoryResponse.class));
    }

    public Mono<ServerResponse> retrieveCategories(ServerRequest request) {

        final Flux<CategoryVO> categories = service.getAll();

        logger.info("retrieveCategories: ", categories);
        final Flux<CategoryResponse> resource = assembler.toResource(categories);

        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(resource, CategoryResponse.class));
    }
}
