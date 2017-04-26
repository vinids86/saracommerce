package br.com.saracommerce.department.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vinicius on 23/04/17.
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = -5261528069815818796L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return (getId() != null ? getId().equals(that.getId()) : that.getId() == null) && (getName() != null ? getName().equals(that.getName()) : that.getName() == null);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
