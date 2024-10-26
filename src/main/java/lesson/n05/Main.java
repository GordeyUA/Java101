package lesson.n05;

import lesson.n05.model.Role;
import lesson.n05.model.User;
import lesson.n05.repository.RoleRepository;
import lesson.n05.repository.RoleRepositoryImpl;
import lesson.n05.repository.UserRepository;
import lesson.n05.repository.UserRepositoryImpl;

import java.util.List;

public final class Main {

  private Main() { }

  public static void main(String[] args) {
    RoleRepository roleRepository = new RoleRepositoryImpl();
    UserRepository userRepository = new UserRepositoryImpl();

    Role roleAdmin = roleRepository.create(new Role("admin"));
    Role roleUser = roleRepository.create(new Role("user"));

    Role role = roleRepository.findById(roleAdmin.getId()).orElseThrow();
    System.out.println("Role found by ID: " + role);

    User userBob = userRepository.create(new User("Bob", "bob@mail.com"));

    userBob.setRoles(List.of(roleAdmin, roleUser));
    User user = userRepository.update(userBob);
    System.out.println("Updated user: " + user);

    user = userRepository.findById(userBob.getId()).orElseThrow();
    System.out.println("User found by ID: " + user);
  }
}
