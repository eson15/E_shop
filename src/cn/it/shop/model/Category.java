package cn.it.shop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
//	private Set<Product> products = new HashSet<Product>(0);


	// Constructors

	/** default constructor */
	public Category() {
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", account=" + account + ", type=" + type
				+ ", hot=" + hot + "]";
	}

	/** full constructor */
	public Category(Account account, String type, Boolean hot,
			Set<Product> products) {
		this.account = account;
		this.type = type;
		this.hot = hot;
//		this.products = products;
	}

	public Category(Integer id, String type, Boolean hot) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	public Category(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
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

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
//	public Set<Product> getProducts() {
//		return this.products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}

}