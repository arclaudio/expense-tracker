package com.arclaudio.expense.service.impl;

import com.arclaudio.expense.dto.ExpenseDTO;
import com.arclaudio.expense.entity.Category;
import com.arclaudio.expense.entity.Expense;
import com.arclaudio.expense.exception.ResourceNotFoundException;
import com.arclaudio.expense.mapper.CategoryMapper;
import com.arclaudio.expense.mapper.ExpenseMapper;
import com.arclaudio.expense.repository.CategoryRepository;
import com.arclaudio.expense.repository.ExpenseRepository;
import com.arclaudio.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDTO);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDTO(savedExpense);
    }

    @Override
    public ExpenseDTO getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense with id: "+expenseId+" not found!"));
        return ExpenseMapper.mapToExpenseDTO(expense);
    }

    @Override
    public List<ExpenseDTO> getExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::mapToExpenseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long expenseId, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense with id: "+expenseId+" not found!"));
        expense.setAmount(expenseDTO.amount());
        expense.setExpenseDate(expenseDTO.expenseDate());

        if(expenseDTO.categoryDTO() != null){
            Category category = categoryRepository.findById(expenseDTO.categoryDTO().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Category with id: "+expenseDTO.categoryDTO().id()+" not found!"));

            expense.setCategory(category);
        }
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDTO(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense with id: "+expenseId+" not found!"));
        expenseRepository.delete(expense);
    }
}
