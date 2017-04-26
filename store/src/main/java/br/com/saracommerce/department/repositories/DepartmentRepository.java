package br.com.saracommerce.department.repositories;

import br.com.saracommerce.department.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vinicius on 23/04/17.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findById(Long id);
}
