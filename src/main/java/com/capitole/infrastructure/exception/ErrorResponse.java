package com.capitole.infrastructure.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Standard error response structure for API exceptions.
 */
@Getter
@Builder
@Schema(description = "Error response object")
public class ErrorResponse {

    @Schema(description = "HTTP status code", example = "404")
    private int status;

    @Schema(description = "Error message describing what went wrong", example = "No applicable price found for the given parameters.")
    private String message;

    @Schema(description = "Timestamp when the error occurred", example = "2024-04-26T14:45:00")
    private LocalDateTime timestamp;
}
