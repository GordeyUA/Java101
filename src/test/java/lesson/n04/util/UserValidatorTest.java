package lesson.n04.util;

import lesson.n04.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

  @Test
  void checkUser_EmailInvalid_A() {
    UserRegistrationDto user = new UserRegistrationDto();
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Invalid email."
    );
  }

  @Test
  void checkUser_EmailInvalid_B() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Invalid email."
    );
  }

  @Test
  void checkUser_EmailInvalid_C() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Invalid email."
    );
  }

  @Test
  void checkUser_EmailInvalid_D() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob@gmail");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Invalid email."
    );
  }

  @Test
  void checkUser_PhoneInvalid() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob@gmail.com");
    user.setPhoneNumber("abc");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Invalid phone number."
    );
  }

  @Test
  void checkUser_PasswordEmpty() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob@gmail.com");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Password should be set."
    );
  }

  @Test
  void checkUser_PasswordNotMatches() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob@gmail.com");
    user.setPassword("123");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Password didn't match repeat password."
    );
  }

  @Test
  void checkUser_Ok() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("bob@gmail.com");
    user.setPhoneNumber("+380 50 555-5555");
    user.setPassword("password");
    user.setRepeatPassword("password");

    UserValidator.checkUser(user);
  }
}