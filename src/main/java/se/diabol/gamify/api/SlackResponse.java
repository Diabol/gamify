package se.diabol.gamify.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackResponse {

	private String response_type;
	
	private String text;

	@JsonProperty
	public String getResponse_type() {
		return response_type;
	}
	
	@JsonProperty
	public String getText() {
		return text;
	}
	
	public SlackResponse(String response_type, String text) {
		super();
		this.response_type = response_type;
		this.text = text;
	}
}
