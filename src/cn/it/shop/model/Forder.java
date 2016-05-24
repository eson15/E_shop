package cn.it.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Forder implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -466590347484970656L;
	
	private Integer id;
	private User user;
	private Status status;
	private String name;
	private String phone;
	private String remark;
	private Date date;
	private BigDecimal total;
	private String post;
	private String address;
	private List<Sorder> sorders = new ArrayList<Sorder>();

	// Constructors

	/** default constructor */
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Date date) {
		this.date = date;
	}

	public Forder(List<Sorder> sorders) {
		super();
		this.sorders = sorders;
	}

	/** full constructor */
	public Forder(User user, Status status, String name, String phone,
			String remark, Date date, BigDecimal total, String post,
			String address, List<Sorder> sorders) {
		this.user = user;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.remark = remark;
		this.date = date;
		this.total = total;
		this.post = post;
		this.address = address;
		this.sorders = sorders;
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
	@JoinColumn(name = "uid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sid")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "remark", length = 20)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "date", nullable = true, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "total", precision = 8)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "post", length = 20)
	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forder")
	public List<Sorder> getSorders() {
		return this.sorders;
	}

	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}

}