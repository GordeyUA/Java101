package lesson.n04;

import lesson.n04.dto.UserRegistrationDto;
import lesson.n04.dto.UserResponseDto;
import lesson.n04.repository.UserRepositoryImpl;
import lesson.n04.service.UserService;
import lesson.n04.service.UserServiceImpl;

public final class Main {

  private Main() { }

  public static void main(String[] args) {
    UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    System.out.println("Saving user...");
    UserResponseDto registeredUser = userService.registerUser(new UserRegistrationDto("bob@gmail.com", "", "password", "password"));
    System.out.println("\nRegistered user: "
      + "id = " + registeredUser.getId()
      + ", email = " + registeredUser.getEmail()
      + ", phone number = " + registeredUser.getPhoneNumber());

    System.out.println("\nFind user by ID:");
    UserResponseDto foundUser = userService.getUserById(registeredUser.getId());
    System.out.println("\nFound user: "
      + "id = " + foundUser.getId()
      + ", email = " + foundUser.getEmail()
      + ", phone number = " + foundUser.getPhoneNumber());
  }
}
