package br.com.saracommerce.productcatalog.application.routes;

import br.com.saracommerce.productcatalog.application.CategoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * Created by sara on ago, 2018
 */
@Configuration
public class CategoryRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CategoryHandler handler) {
        return RouterFunctions
                .route(POST("/category").and(accept(APPLICATION_JSON)), handler::createCategory)
                .andRoute(GET("/category").and(accept(APPLICATION_JSON)), handler::retrieveCategories);
    }
}
