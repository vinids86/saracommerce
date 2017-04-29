package br.com.saracommerce.department.models;

import br.com.saracommerce.core.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vinicius on 23/04/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
@Table(name = "department")
public class Department extends AbstractEntity {

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Category> categories;
}
