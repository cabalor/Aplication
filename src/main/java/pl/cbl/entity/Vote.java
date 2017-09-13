package pl.cbl.entity;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class Vote {

	private int id;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date crt;
	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;
	private VotingEnum voteType;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCrt() {
		return crt;
	}

	public void setCrt(Date crt) {
		this.crt = crt;
	}

	public Vote() {
	}

}
