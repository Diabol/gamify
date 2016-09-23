package se.diabol.gamify.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.diabol.gamify.api.SlackResponse;

@Path("/gamify")
@Produces(MediaType.APPLICATION_JSON)
public class SlackResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SlackResource.class);
	
	@GET
	public SlackResponse say(@QueryParam("user_name") String username, @QueryParam("text") String text) {
		LOGGER.info("Request from {}: {}", username, text);
		String result = "Congratulations @" + username + " on earning your " + text + " badge!";
		
		return new SlackResponse("in_channel", result);
	} 

}
