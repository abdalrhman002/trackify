package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.dto.request.UserRequestDto;
import com.mujahid.trackify.domain.dto.response.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto getCurrentUser();
    UserResponseDto updateCurrentUser(UserRequestDto userRequestDto);
    void deleteCurrentUser();
    Boolean ExistsByEmail(String email);
}
