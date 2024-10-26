package lesson.n05.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
  private static final SessionFactory SESSION_FACTORY = initSessionFactory();

  private HibernateUtil() {
  }

  private static SessionFactory initSessionFactory() {
    try {
      return new Configuration().configure().buildSessionFactory();
    } catch (Exception e) {
      throw new RuntimeException("Can't create session factory ", e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }
}
