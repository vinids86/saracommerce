package br.com.saracommerce.product.models;

import br.com.saracommerce.core.AbstractEntity;
import br.com.saracommerce.department.models.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vinicius on 27/04/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, exclude = "subCategory")
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Price> price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;
}
