package pl.cbl.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="user")
public class User {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String login;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Post> posts; 
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Vote> votes;
	
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Boolean isPasswordCorrect(String password) {
		return BCrypt.checkpw(password, this.password);
	}
	
	public User() {}
	
	
	@Override
	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	public User(String login, String password, String email, String firstName, String lastName) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
