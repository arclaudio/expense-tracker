package com.arclaudio.expense.controller;

import com.arclaudio.expense.dto.ExpenseDTO;
import com.arclaudio.expense.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Expense Resource",
        description = "CRUD REST APIs for Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Operation(
            summary = "Create new Expense REST API",
            description = "Save new Expense into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO expense = expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Expense by Id REST API",
            description = "Retrieve Expense by Id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDTO expense = expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expense);
    }

    @Operation(
            summary = "Get all Expenses REST API",
            description = "Retrieve all Expenses from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getExpenses(){
        List<ExpenseDTO> expenses = expenseService.getExpenses();
        return ResponseEntity.ok(expenses);
    }

    @Operation(
            summary = "Update Expense by Id REST API",
            description = "Update Expense by Id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO updatedExpense = expenseService.updateExpense(expenseId, expenseDTO);
        return ResponseEntity.ok(updatedExpense);
    }

    @Operation(
            summary = "Delete Expense by Id REST API",
            description = "Delete Expense by Id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully!");
    }
}
