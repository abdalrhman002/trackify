package com.mujahid.trackify.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
