package com.FinalProject.Our_Closet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.FinalProject.Our_Closet.model.*;
import java.util.List;


public interface PostsRepo extends JpaRepository<Posts, Integer>{
	
	@Query(value = "SELECT * FROM Posts",
			nativeQuery = true)
	List<Posts> returnAllPosts();
	
}
