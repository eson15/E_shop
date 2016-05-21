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
 * Status entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Status implements java.io.Serializable {

	// Fields

	private Integer id;
	private String status;
	private Set<Forder> forders = new HashSet<Forder>(0);

	// Constructors

	/** default constructor */
	public Status() {
	}

	
	public Status(String status) {
		super();
		this.status = status;
	}


	/** full constructor */
	public Status(String status, Set<Forder> forders) {
		this.status = status;
		this.forders = forders;
	}

	
	public Status(Integer id) {
		super();
		this.id = id;
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

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "status")
	public Set<Forder> getForders() {
		return this.forders;
	}

	public void setForders(Set<Forder> forders) {
		this.forders = forders;
	}

}