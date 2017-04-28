package br.com.saracommerce.department.controllers.resources;

import br.com.saracommerce.department.controllers.DepartmentController;
import br.com.saracommerce.department.models.Department;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by vinicius on 25/04/17.
 */
@Service
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource> {

    public DepartmentResourceAssembler() {
        super(DepartmentController.class, DepartmentResource.class);
    }

    @Override
    public DepartmentResource toResource(Department department) {

        final DepartmentResource resource = createResourceWithId(department.getId(), department);
        resource.setDepartmentId(department.getId());
        resource.setName(department.getName());

        final ArrayList<CategoryResource> categoriesResource = new ArrayList<>();

        department.getCategories().ifPresent(
                categories -> categories.forEach(category -> {

                            final CategoryResource categoryResource = new CategoryResource();
                            categoryResource.setName(category.getName());

                            final ArrayList<SubCategoryResource> subCategoriesResource = new ArrayList<>();

                            category.getSubCategories().ifPresent(subCategories -> subCategories.forEach(subCategory -> {
                                final SubCategoryResource subCategoryResource = new SubCategoryResource();
                                subCategoryResource.setName(subCategory.getName());
                                subCategoriesResource.add(subCategoryResource);
                            }));

                            categoryResource.setSubCategories(subCategoriesResource);

                            categoriesResource.add(categoryResource);
                            resource.setCategories(categoriesResource);
                        }
                ));

        return resource;
    }
}
