package se.diabol.gamify.core.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "se.diabol.gamify.core.domain.User.findUserBySlackUserId",
            query = "select u from User u "
            + "where u.slackUserId = :slackUserId ")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String slackUserId;

	private String slackUsername;
	
	private Date registered;

	@OneToMany
	private Set<UserAction> actions;
	
	@OneToMany
	private Set<UserAchievement> achievements;
	
	public User() {
		super();
	}

	public User(String slackUserId, String slackUsername) {
		super();
		this.slackUserId = slackUserId;
		this.slackUsername = slackUsername;
		this.registered = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSlackUserId() {
		return slackUserId;
	}
	
	public void setSlackUserid(String slackUserId) {
		this.slackUserId = slackUserId;
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
