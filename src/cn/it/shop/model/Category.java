package cn.it.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + ", hot=" + hot
				+ "]";
	}

	private String type;
	private Boolean hot;
	private Integer aid;

	// Constructors

	/** default constructor */
	public Category() {
	}
	
	/** full constructor */
	public Category(String type, Boolean hot) {
		this.type = type;
		this.hot = hot;
	}
	
	public Category(Integer id, String type, Boolean hot) {
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	/** full constructor */
	public Category(String type, Boolean hot, Integer aid) {
		this.type = type;
		this.hot = hot;
		this.aid = aid;
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

	@Column(name = "aid")
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

}