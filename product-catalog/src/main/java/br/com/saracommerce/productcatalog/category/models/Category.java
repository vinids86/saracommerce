package br.com.saracommerce.productcatalog.category.models;

import br.com.saracommerce.productcatalog.core.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Document(collection = "category")
public class Category extends BaseEntity {

    @Indexed
    private String name;

}
