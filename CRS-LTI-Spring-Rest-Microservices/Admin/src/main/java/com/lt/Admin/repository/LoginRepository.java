/**
 * 
 */
package com.lt.Admin.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.Admin.beans.UserLogin;


/**
 * @author Jeaswanth
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<UserLogin, String> {

	
	UserLogin findByUserNameAndPasswordAndIsApprovedTrue(String userName, String password);
	
	

}
