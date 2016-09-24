package se.diabol.gamify.db;

import org.hibernate.SessionFactory;

import se.diabol.gamify.core.domain.User;
import io.dropwizard.hibernate.AbstractDAO;

public class UserDao extends AbstractDAO<User> {

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

    public User findById(Long id) {
        return get(id);
    }

    public long create(User user) {
        return persist(user).getId();
    }

}
