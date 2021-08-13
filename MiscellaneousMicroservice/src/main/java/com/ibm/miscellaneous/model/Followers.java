package com.ibm.miscellaneous.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="followers")

public class Followers {

	@Id
	private Integer id;
	
	@Column
	private String userId;
	
	@Column
	private String followsUserId;
	
	

	public Followers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Followers(String userId, String followsUserId) {
		super();
		this.userId = userId;
		this.followsUserId = followsUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowsUserId() {
		return followsUserId;
	}

	public void setFollowsUserId(String followsUserId) {
		this.followsUserId = followsUserId;
	}

	@Override
	public String toString() {
		return "Folowers [id=" + id + ", userId=" + userId + ", followsUserId=" + followsUserId + "]";
	}
	
	
}
