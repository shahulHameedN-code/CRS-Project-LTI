/**
 * 
 */
package com.lt.APIGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lt.APIGateway.beans.UserLogin;

/**
 * @author Jeaswanth
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<UserLogin, String> {

	
	UserLogin findByUserNameAndPasswordAndIsApprovedTrue(String userName, String password);

}
