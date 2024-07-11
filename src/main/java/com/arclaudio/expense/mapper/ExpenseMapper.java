package com.arclaudio.expense.mapper;

import com.arclaudio.expense.dto.CategoryDTO;
import com.arclaudio.expense.dto.ExpenseDTO;
import com.arclaudio.expense.entity.Category;
import com.arclaudio.expense.entity.Expense;

public class ExpenseMapper {

    public static Expense mapToExpense(ExpenseDTO expenseDTO){
        Category category = new Category();
        category.setId(expenseDTO.categoryDTO().id());
        return new Expense(
                expenseDTO.id(),
                expenseDTO.amount(),
                expenseDTO.expenseDate(),
                category
        );
    }

    public static ExpenseDTO mapToExpenseDTO(Expense expense){
        return new ExpenseDTO(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDTO(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }
}
