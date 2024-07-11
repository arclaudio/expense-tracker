package com.arclaudio.expense.service;

import com.arclaudio.expense.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO getExpenseById(Long expenseId);

    List<ExpenseDTO> getExpenses();

    ExpenseDTO updateExpense(Long expenseId, ExpenseDTO expenseDTO);

    void deleteExpense(Long expenseId);
}
