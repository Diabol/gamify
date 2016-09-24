package se.diabol.gamify.resources;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.diabol.gamify.api.SlackResponse;
import se.diabol.gamify.core.domain.User;
import se.diabol.gamify.db.UserDao;

@Path("/gamify")
@Produces(MediaType.APPLICATION_JSON)
public class SlackResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SlackResource.class);
	
	private UserDao userDao;
	
	public SlackResource(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@GET
    @UnitOfWork
	public SlackResponse say(@QueryParam("user_name") String slackUsername, @QueryParam("user_id") String slackUserId, @QueryParam("text") String text) {
		LOGGER.info("Request from {}: {}", slackUsername, text);
		
		User user = userDao.findBySlackUserId(slackUserId);
		if (user == null) {
			user = new User(slackUserId, slackUsername);
			long id = userDao.create(user);
			LOGGER.info("Created user {}", slackUsername);
			user = userDao.findById(id);
		}

		String result = "Congratulations @" + slackUsername + " on earning your " + text + " badge!";
		
		return new SlackResponse("in_channel", result);
	} 

}
