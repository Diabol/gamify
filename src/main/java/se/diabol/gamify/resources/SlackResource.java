package se.diabol.gamify.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/gamify")
@Produces(MediaType.TEXT_PLAIN)
public class SlackResource {
	
	@GET
	public String say(@QueryParam("user_name") String username, @QueryParam("text") String text) {
		String result = "Congratulations " + username + " on earning your " + text + " badge!";
		
		return result;
	} 

}
