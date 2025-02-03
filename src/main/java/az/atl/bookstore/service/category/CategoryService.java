package az.atl.bookstore.service.category;

import az.atl.bookstore.dto.CategoryDto;
import az.atl.bookstore.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity createdCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
}

