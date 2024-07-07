package com.arclaudio.expense.mapper;

import com.arclaudio.expense.dto.CategoryDTO;
import com.arclaudio.expense.entity.Category;

public class CategoryMapper {

    // Map CategoryDto to Category entity
    public static Category mapToCategory(CategoryDTO categoryDTO){
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()
        );
    }

    // Map Category Entity to CategoryDto
    public CategoryDTO mapToCategoryDto(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}