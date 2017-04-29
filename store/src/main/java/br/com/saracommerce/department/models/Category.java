package br.com.saracommerce.department.models;

import br.com.saracommerce.core.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@ToString(callSuper = true, exclude = "department")
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;
}
