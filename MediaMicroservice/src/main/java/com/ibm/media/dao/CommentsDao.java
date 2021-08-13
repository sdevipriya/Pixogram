package com.ibm.media.dao;


import org.springframework.stereotype.Repository;

import com.ibm.media.model.Comments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentsDao extends JpaRepository<Comments, Integer>{

	List<Comments> findByNewsFeedId(Integer mediaid);

	Comments findByUserId(String userId);
	Comments findByUserIdAndNewsFeedId(String userId, Integer newsFeedId);

	Integer countByNewsFeedIdAndLikes(Integer newsFeedId, boolean likes);

	Integer countByNewsFeedIdAndDislike(Integer newsFeedId, boolean dislike);

	Integer countByNewsFeedIdAndCommentNotNull(Integer newsFeedId);

	
	
}
