package com.arclaudio.expense.controller;

import com.arclaudio.expense.dto.CategoryDTO;
import com.arclaudio.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    // Create Category REST API
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO category = categoryService.createCategory(categoryDTO);
        return  new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // Get Category By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDTO);
    }

    // Get All Categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    // Update Category REST API
    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDTO categoryDTO){
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryId, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    //Delete Category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
