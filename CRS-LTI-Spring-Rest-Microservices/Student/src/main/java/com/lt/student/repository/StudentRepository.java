package com.lt.student.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.student.beans.Student;

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
