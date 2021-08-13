package com.ibm.media.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibm.media.model.Media;

@Repository
public interface MediaDao extends JpaRepository<Media, Integer>{

	List<Media> findByuserId(String userId);
	//List<Media> findByuserid(String userid);

	Media findBymediaId(Integer mediaId);

	List<Media> findByhide(Boolean hide);
}
