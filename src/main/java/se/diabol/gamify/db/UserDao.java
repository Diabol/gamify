package se.diabol.gamify.db;

import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.UnitOfWork;

import org.hibernate.SessionFactory;

import se.diabol.gamify.core.domain.User;

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

    public User findBySlackUserId(String slackUserId) {
    	return uniqueResult(namedQuery("se.diabol.gamify.core.domain.User.findUserBySlackUserId")
    			.setParameter("slackUserId", slackUserId));
    }
}
