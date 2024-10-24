package lesson.n04.service;

import lesson.n04.dto.UserRegistrationDto;
import lesson.n04.dto.UserResponseDto;

public interface UserService {

  UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

  UserResponseDto getUserById(Long userId);
}
