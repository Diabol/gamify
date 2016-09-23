package se.diabol.gamify.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import se.diabol.gamify.api.SlackResponse;

@Path("/gamify")
@Produces(MediaType.APPLICATION_JSON)
public class SlackResource {
	
	@GET
	public SlackResponse say(@QueryParam("user_name") String username, @QueryParam("text") String text) {
		String result = "Congratulations @" + username + " on earning your " + text + " badge!";
		
		return new SlackResponse("in_channel", result);
	} 

}
