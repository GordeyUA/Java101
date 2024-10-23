package lesson.n04.service;

import lesson.n04.dto.UserRegistrationDto;
import lesson.n04.dto.UserResponseDto;
import lesson.n04.model.User;
import lesson.n04.repository.UserRepository;
import lesson.n04.util.UserValidator;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponseDto registerUser(UserRegistrationDto user) {
    UserValidator.checkUser(user);

    User userRequest = new User();
    userRequest.setEmail(user.getEmail());
    userRequest.setPhoneNumber(user.getPhoneNumber());
    userRequest.setPassword(user.getPassword());

    User userResponse = userRepository.save(userRequest);

    return new UserResponseDto(userResponse.getId(), userResponse.getEmail(), userResponse.getPhoneNumber());
  }

  @Override
  public UserResponseDto getUserById(Long userId) {
    return userRepository.findById(userId)
      .map(user -> new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber()))
      .orElseThrow();
  }
}
