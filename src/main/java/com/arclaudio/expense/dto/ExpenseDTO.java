package com.arclaudio.expense.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense Data Transfer Object (DTO) to transfer data between client and server"
)
public record ExpenseDTO(Long id,
                         @Schema(
                                 description = "Expense amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense created date"
                         )
                         LocalDate expenseDate,
                         @Schema(
                                 description = "Associated Expense Category"
                         )
                         CategoryDTO categoryDTO) {
}
