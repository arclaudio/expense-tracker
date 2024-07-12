package com.arclaudio.expense.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDetails Data Transfer Object (DTO) to transfer the error response data between client and server"
)
public record ErrorDetails(
        @Schema(
                description = "Error occurred date and time"
        )
        LocalDateTime timestamp,

        @Schema(
                description = "Error message"
        )
        String message,

        @Schema(
                description = "Error details"
        )
        String detail,

        @Schema(
                description = "Error code"
        )
        String errorCode) {

}
