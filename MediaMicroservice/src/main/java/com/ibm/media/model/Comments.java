package com.ibm.media.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Comments {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer newsFeedId;
	@Column
	private String comment;
	@Column
	private String userId;
	@Column
	private Boolean dislike =false;
	@Column
	private Boolean likes =false;
	@Column
	@CreationTimestamp
	private Date DateTime;
	
	public Comments(Integer newsFeedId, String comment, String userId, Boolean likes, Boolean dislike) {
		super();
		this.newsFeedId = newsFeedId;
		this.comment = comment;
		this.userId = userId;
		this.likes = likes;
		this.dislike = dislike;
	}
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNewsFeedId() {
		return newsFeedId;
	}
	public void setNewsFeedId(Integer newsFeedId) {
		this.newsFeedId = newsFeedId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public Boolean getLike() {
		return likes;
	}

	public void setLike(Boolean likes) {
		this.likes = likes;
	}

	public Boolean getDislike() {
		return dislike;
	}

	public void setDislike(Boolean dislike) {
		this.dislike = dislike;
	}

	@Override
	public String toString() {
		return "Comments [newsFeedId=" + newsFeedId + ", comment=" + comment + ", userId=" + userId + ", DateTime="
				+ DateTime + "]";
	}

	
	
}
