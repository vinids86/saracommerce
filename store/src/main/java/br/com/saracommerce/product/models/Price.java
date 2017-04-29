package br.com.saracommerce.product.models;

import br.com.saracommerce.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by vinicius on 27/04/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, exclude = "product")
@Entity
@Table(name = "price")
public class Price extends AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePrice type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
