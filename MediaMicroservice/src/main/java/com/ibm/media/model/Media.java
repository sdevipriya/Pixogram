package com.ibm.media.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name="media")
@Data
public class Media {
	@Column
	private String userId;
	@Id
	@GeneratedValue
	private Integer mediaId;
	@Column
	private String mediaURL;
	@Column
	private String mimeType;
	@Column
	private String mediaTitle;
	@Column
	private String mediaCaption;
	@Column
	@CreationTimestamp
	private Date uploadedDateTime;
	@Column
	private Boolean hide;
	@Column
	private String description;
	@Column
	private String effects;
	@Column
	private String tags;
	@Column
	private Integer likesCount;
	@Column
	private Integer dislikesCount;
	@Column 
	private Integer commentsCount; 
	
	public Media() {
		super();
	}
	public Media(String userid, Integer mediaId, String mediaURL, String mimeType, String mediaTitle,
			String mediaCaption, Boolean hide, String description, String effects,
			String tags, Integer likesCount, Integer dislikeCount, Integer commentsCount) {
		super();
		this.userId = userid;
		this.mediaId = mediaId;
		this.mediaURL = mediaURL;
		this.mimeType = mimeType;
		this.mediaTitle = mediaTitle;
		this.mediaCaption = mediaCaption;
		
		this.hide = hide;
		this.description = description;
		this.effects = effects;
		this.tags = tags;
		this.likesCount = likesCount;
		this.dislikesCount = dislikeCount;
		this.commentsCount = commentsCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEffects() {
		return effects;
	}
	public void setEffects(String effects) {
		this.effects = effects;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getUserid() {
		return userId;
	}
	public void setUserid(String userid) {
		this.userId = userid;
	}
	public Integer getMediaId() {
		return mediaId;
	}
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getMediaTitle() {
		return mediaTitle;
	}
	public void setMediaTitle(String mediaTitle) {
		this.mediaTitle = mediaTitle;
	}
	public String getMediaCaption() {
		return mediaCaption;
	}
	public void setMediaCaption(String mediaCaption) {
		this.mediaCaption = mediaCaption;
	}
	public Date getUploadedDateTime() {
		return uploadedDateTime;
	}
	public void setUploadedDateTime(Date uploadedDateTime) {
		this.uploadedDateTime = uploadedDateTime;
	}
	public Boolean getHide() {
		return hide;
	}
	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	
	
	public Integer getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}
	public Integer getDislikesCount() {
		return dislikesCount;
	}
	public void setDislikesCount(Integer dislikesCount) {
		this.dislikesCount = dislikesCount;
	}
	
	public Integer getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}
	@Override
	public String toString() {
		return "Media [userId=" + userId + ", mediaId=" + mediaId + ", mediaURL=" + mediaURL + ", mimeType=" + mimeType
				+ ", mediaTitle=" + mediaTitle + ", mediaCaption=" + mediaCaption + ", uploadedDateTime="
				+ uploadedDateTime + ", hide=" + hide + ", description=" + description + ", effects=" + effects
				+ ", tags=" + tags + ", likesCount=" + likesCount + ", dislikesCount=" + dislikesCount
				+ ", commentsCount=" + commentsCount + "]";
	}
	
	
	
	
	

}
