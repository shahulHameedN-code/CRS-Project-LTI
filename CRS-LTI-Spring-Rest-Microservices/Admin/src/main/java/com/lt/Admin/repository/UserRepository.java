package com.lt.Admin.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.Admin.beans.UserLogin;


@Repository
public interface UserRepository extends JpaRepository<UserLogin, String> {
	

	@Modifying
	@Transactional
	@Query(value = "update user set is_approved=true where user_id=:user_id", nativeQuery = true)
	int approvedStudentByAdmin(@Param("user_id") String userId);

	

}
