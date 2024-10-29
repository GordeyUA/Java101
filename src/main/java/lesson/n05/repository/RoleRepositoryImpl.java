package lesson.n05.repository;

import lesson.n05.model.Role;
import lesson.n05.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {

  private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public Role create(Role role) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.getTransaction();
      transaction.begin();
      session.persist(role);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return role;
  }

  @Override
  public Optional<Role> findById(Long id) {
    try (Session session = sessionFactory.openSession()) {
      return Optional.ofNullable(session.find(Role.class, id));
    }
  }
}
