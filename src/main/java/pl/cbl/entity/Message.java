package pl.cbl.entity;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class Message {

	private long id;
	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created;
	@ManyToOne
	private User user;
	private User reciver;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", created=" + created + ", user=" + user + ", reciver="
				+ reciver + "]";
	}
	
	
}
