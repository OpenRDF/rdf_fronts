package com.openrdf.beans;

/**
 * ConceptStore entity. @author MyEclipse Persistence Tools
 */

public class ConceptStore implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private String keyword;
	private String storeTime;
	private String other;

	// Constructors

	/** default constructor */
	public ConceptStore() {
	}

	/** full constructor */
	public ConceptStore(String userId, String keyword, String storeTime,
			String other) {
		this.userId = userId;
		this.keyword = keyword;
		this.storeTime = storeTime;
		this.other = other;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStoreTime() {
		return this.storeTime;
	}

	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}