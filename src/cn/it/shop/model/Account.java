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
 * Account entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pass;
//	private Set<Category> categories = new HashSet<Category>(0);

	
	// Constructors

	/** default constructor */
	public Account() {
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", name=" + name
				+ ", pass=" + pass + "]";
	}

	/** full constructor */
	public Account(String login, String name, String pass,
			Set<Category> categories) {
		this.login = login;
		this.name = name;
		this.pass = pass;
//		this.categories = categories;
	}
	

	public Account(String login, String name, String pass) {
		super();
		this.login = login;
		this.name = name;
		this.pass = pass;
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

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
//	public Set<Category> getCategories() {
//		return this.categories;
//	}
//
//	public void setCategories(Set<Category> categories) {
//		this.categories = categories;
//	}

}