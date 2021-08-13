package com.ibm.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import lombok.Data;


@Entity
@Table(name="User")
@Data
public class Users {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String userId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String confirm;
	@Column
	private String profilePictureUrl;
	@Column
	@CreationTimestamp
	private Date createdDateTime;
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String userId, String userName, String password, String confirm, String profilePictureUrl) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.confirm = confirm;
		this.profilePictureUrl = profilePictureUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", confirm=" + confirm + ", profilePictureUrl=" + profilePictureUrl + ", createdDateTime="
				+ createdDateTime + "]";
	}
	
	
}
