package lesson.n04.util;

import lesson.n04.dto.UserRegistrationDto;
import java.util.regex.Pattern;

public final class UserValidator {

  private static final Pattern MAIL_PATTERN =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
  private static final Pattern PHONE_PATTERN =
    Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");

  private UserValidator() { }

  public static void checkUser(UserRegistrationDto user) {
    if (!MAIL_PATTERN.matcher(user.getEmail()).matches()) {
      throw new RuntimeException("Invalid email.");
    }

    if (!user.getPhoneNumber().isEmpty() && !PHONE_PATTERN.matcher(user.getPhoneNumber()).matches()) {
      throw new RuntimeException("Invalid phone number.");
    }

    if (user.getPassword().isEmpty()) {
      throw new RuntimeException("Password should be set.");
    }

    if (!user.getPassword().matches(user.getRepeatPassword())) {
      throw new RuntimeException("Password didn't match repeat password.");
    }
  }
}
