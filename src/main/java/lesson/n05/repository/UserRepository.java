package lesson.n05.repository;

import lesson.n05.model.User;
import java.util.Optional;

public interface UserRepository {

  User create(User user);

  User update(User user);

  Optional<User> findById(Long id);
}
