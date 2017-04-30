package br.com.saracommerce.department.repositories;

import br.com.saracommerce.department.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by vinicius on 23/04/17.
 */
@Repository
@Transactional(readOnly = true)
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
}
