/**
 * 
 */
package com.lt.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lt.application.entity.UserLogin;

/**
 * @author Jeaswanth
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<UserLogin, String> {

	
	UserLogin findByUserNameAndPasswordAndIsApprovedTrue(String userName, String password);

}
