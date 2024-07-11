package com.arclaudio.expense.repository;

import com.arclaudio.expense.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
