package com.ibm.media.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import javax.persistence.Column;
import lombok.Data;

@Entity
@Data
public class NewsFeed {
	
	@Id
	//@JoinColumn(referencedColumnName = "mediaId", unique = true)
	private Integer mediaId;
	//@JoinColumn(referencedColumnName = "userId", unique = true)
	private String userId;
	@Column
	@CreationTimestamp
	private Date postedDateTime;
	@Column
	private String activity;
	
	public NewsFeed(Integer mediaId, String userId, String activity, Date postedDateTime) {
		super();
		this.mediaId = mediaId;
		this.userId = userId;
		this.activity = activity;
		this.postedDateTime=postedDateTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public NewsFeed() {
		// TODO Auto-generated constructor stub
	}

	public Integer getMediaId() {
		return mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(Date postedDateTime) {
		this.postedDateTime = postedDateTime;
	}

	@Override
	public String toString() {
		return "NewsFeed [mediaId=" + mediaId + ", userId=" + userId + ", postedDateTime=" + postedDateTime + ", activity=" + activity +"]";
	}


}
