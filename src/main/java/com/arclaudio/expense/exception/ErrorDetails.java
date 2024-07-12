package com.arclaudio.expense.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                          String message,
                          String detail,
                          String errorCode) {

}
