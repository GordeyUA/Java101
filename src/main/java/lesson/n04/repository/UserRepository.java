package lesson.n04.repository;

import lesson.n04.model.User;

import java.util.Optional;

public interface UserRepository {

  User save(User user);

  Optional<User> findById(Long id);
}
