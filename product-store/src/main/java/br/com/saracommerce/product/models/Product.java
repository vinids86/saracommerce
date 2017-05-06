package br.com.saracommerce.product.models;

import br.com.saracommerce.category.models.Category;
import br.com.saracommerce.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by vinicius on 01/05/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true)
@Entity
@Table(name = "PRODUCT")
public class Product extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGULAR_PRICE")
    private BigDecimal regularPrice;

    @Column(name = "SALE_PRICE")
    private BigDecimal salePrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}
