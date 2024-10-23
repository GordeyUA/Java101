package lesson.n04.service;

import lesson.n04.dto.UserRegistrationDto;
import lesson.n04.dto.UserResponseDto;
import lesson.n04.model.User;
import lesson.n04.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  void registerUser() {
    Mockito.when(userRepository.save(Mockito.any(User.class)))
      .thenReturn(new User(
        1L,
        "bob@gmail.com",
        "+380 50 555-5555",
        "password"
      ));

    UserResponseDto user = userService.registerUser(new UserRegistrationDto("bob@gmail.com", "+380 50 555-5555", "password", "password"));
    assertEquals(1L, user.getId());
    assertEquals("bob@gmail.com", user.getEmail());
    assertEquals("+380 50 555-5555", user.getPhoneNumber());
  }

  @Test
  void getUserById() {
    Mockito.when(userRepository.findById(1L))
      .thenReturn(Optional.of(new User(1L, "bob@gmail.com", "+380 50 555-5555", "password")));

    Mockito.when(userRepository.findById(2L))
      .thenReturn(Optional.empty());

    UserResponseDto user = userService.getUserById(1L);
    assertEquals(1L, user.getId());
    assertEquals("bob@gmail.com", user.getEmail());
    assertEquals("+380 50 555-5555", user.getPhoneNumber());

    assertThrows(
      RuntimeException.class,
      () -> userService.getUserById(2L),
      "Can't find user by id. ID=2"
    );
  }
}