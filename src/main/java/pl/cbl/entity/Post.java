package pl.cbl.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String title;
	private String msg;
	@ManyToOne
	private User user;
	@Temporal(TemporalType.TIMESTAMP)
	//@Column(name="crt")
	@CreationTimestamp
	private Date created;
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Vote> votes;
	@Column(columnDefinition="int deafult 0")
	private int up_vote;
	@Column(columnDefinition="int deafult 0")
	private int down_vote;
	
	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Date getCreate() {
		return created;
	}


	public void setCreate(Date create) {
		this.created = create;
	}


	public Post(){}

	

	public Post(String title2, User logggedUser) {
		this.title = title2;
		this.user = logggedUser;
	}


	@Override
	public String toString() {
		return "Post [id=" + getId() + ", title=" + title + ", msg=" + msg + ", create=" + created + "]";
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getUp_vote() {
		return up_vote;
	}


	public void setUp_vote(int up_vote) {
		this.up_vote = up_vote;
	}


	public int getDown_vote() {
		return down_vote;
	}


	public void setDown_vote(int down_vote) {
		this.down_vote = down_vote;
	}



	
	
	
	
	
	
	
}
