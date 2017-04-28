package br.com.saracommerce.department.models;

import javax.persistence.*;

/**
 * Created by vinicius on 27/04/17.
 */
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePrice type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePrice getType() {
        return type;
    }

    public void setType(TypePrice type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
