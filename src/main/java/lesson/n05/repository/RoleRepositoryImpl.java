package lesson.n05.repository;

import lesson.n05.model.Role;
import lesson.n05.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {

  private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public Role create(Role role) {
    try (Session session = sessionFactory.openSession()) {
      session.save(role);
    }
    return role;
  }

  @Override
  public Optional<Role> findById(Long id) {
    return Optional.ofNullable(sessionFactory.openSession().find(Role.class, id));
  }
}
