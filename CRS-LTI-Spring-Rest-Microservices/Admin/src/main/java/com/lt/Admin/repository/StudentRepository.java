package com.lt.Admin.repository;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lt.Admin.beans.Student;


/**
 * @author Shahul
 *
 */

/**
 * @author Shahul that an @Repository annotated class is a “Repository” define
 *         instantiation, configuration, and initialization logic for objects.
 */

@Configuration
public interface StudentRepository extends JpaRepository<Student, String> {
	
	
	
}
