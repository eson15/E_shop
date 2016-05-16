package cn.it.shop.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pass;
	private String sex;
	private String phone;
	private String email;
	private Set<Forder> forders = new HashSet<Forder>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String login, String name, String pass, String sex,
			String phone, String email, Set<Forder> forders) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.forders = forders;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login", length = 20)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pass", length = 20)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "sex", length = 20)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Forder> getForders() {
		return this.forders;
	}

	public void setForders(Set<Forder> forders) {
		this.forders = forders;
	}

}