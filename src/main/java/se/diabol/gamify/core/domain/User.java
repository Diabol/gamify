package se.diabol.gamify.core.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String slackUserid;

	private String slackUsername;
	
	private Date registered;

	@OneToMany
	private Set<UserAction> actions;
	
	@OneToMany
	private Set<UserAchievement> achievements;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSlackUserid() {
		return slackUserid;
	}
	
	public void setSlackUserid(String slackUserid) {
		this.slackUserid = slackUserid;
	}
	
	public String getSlackUsername() {
		return slackUsername;
	}
	
	public void setSlackUsername(String slackUsername) {
		this.slackUsername = slackUsername;
	}
	
	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Set<UserAction> getActions() {
		return actions;
	}

	public void setActions(Set<UserAction> actions) {
		this.actions = actions;
	}

	public Set<UserAchievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(Set<UserAchievement> achievements) {
		this.achievements = achievements;
	}
	
	
}
