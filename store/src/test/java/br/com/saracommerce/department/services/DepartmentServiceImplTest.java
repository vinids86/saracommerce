package br.com.saracommerce.department.services;

import br.com.saracommerce.department.infrastructure.exceptions.DepartmentNotFoundException;
import br.com.saracommerce.department.repositories.DepartmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by vinicius on 29/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {

    @Mock DepartmentRepository repository;
    private DepartmentServiceImpl departmentService;

    @Before
    public void setUp() {
        this.departmentService = new DepartmentServiceImpl(repository);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNullDepartmentRepository() {
        new DepartmentServiceImpl(null);
    }

    @Test
    public void saveDepartmentWithCategoryAndSubCategory() {
    }

    @Test
    public void saveDepartmentWithoutCategoryAndSubCategory() {
    }

    @Test
    public void findDepartmentById() {
    }

    @Test(expected = DepartmentNotFoundException.class)
    public void findDepartmentByIdWithIdInvalid() {
    }

    @Test
    public void getAllDepartments() {
    }

    @Test
    public void deleteDepartmentValid() {
    }

    @Test(expected = DepartmentNotFoundException.class)
    public void deleteDepartmentValidNotValid() {
    }

}