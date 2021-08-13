package com.ibm.miscellaneous.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="blockedAccounts")
public class BlockedAccounts {
	
	@Id
	private Integer id;
	
	@Column
	private String userId;
	
	@Column
	private String blockedUserId;
	
	

	public BlockedAccounts(String userId, String blockedUserId) {
		super();
		this.userId = userId;
		this.blockedUserId = blockedUserId;
	}

	public BlockedAccounts() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlockedUserId() {
		return blockedUserId;
	}

	public void setBlockedUserId(String blockedUserId) {
		this.blockedUserId = blockedUserId;
	}

	@Override
	public String toString() {
		return "BlockedAccounts [id=" + id + ", userId=" + userId + ", blockedUserId=" + blockedUserId + "]";
	}
	
	
}
