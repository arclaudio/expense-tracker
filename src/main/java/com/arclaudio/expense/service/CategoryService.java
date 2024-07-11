package com.arclaudio.expense.service;

import com.arclaudio.expense.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    List<CategoryDTO> getCategories();

    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDto);

    void deleteCategory(Long categoryId);
}
