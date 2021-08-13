package com.ibm.media.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibm.media.model.NewsFeed;

@Repository
public interface NewsFeedDao extends JpaRepository<NewsFeed, Integer>{

	List<NewsFeed> findByuserId(String userId);

}
