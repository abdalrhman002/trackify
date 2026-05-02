package com.mujahid.trackify.domain.dto.response;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String firstName,
        String lastName,
        String email
) {
}
