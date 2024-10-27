package lesson.n05.repository;

import lesson.n05.model.Role;
import java.util.Optional;

public interface RoleRepository {

  Role create(Role role);

  Optional<Role> findById(Long id);
}
