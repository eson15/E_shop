package cn.it.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private String type;
	private Boolean hot;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Account account, String type, Boolean hot) {
		this.account = account;
		this.type = type;
		this.hot = hot;
	}

	public Category(Integer id, String type, Boolean hot) {
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	public Category(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
	}

	
	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type
				+ ", hot=" + hot + "]";
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "hot")
	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}