package com.FinalProject.Our_Closet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.FinalProject.Our_Closet.model.*;

import java.util.Collection;
import java.util.List;

import com.FinalProject.Our_Closet.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	Users findByuscEmail(String uscEmail);

	@Query(value ="SELECT userID FROM Users ORDER BY userID DESC LIMIT 1",
			nativeQuery = true)
	Integer findNextID();
	
	@Query(value = "SELECT * FROM Users",
			nativeQuery = true)
	List<Users> returnAllUsers();
	
}
