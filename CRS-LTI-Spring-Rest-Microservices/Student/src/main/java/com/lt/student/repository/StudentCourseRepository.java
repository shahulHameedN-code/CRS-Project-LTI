package com.lt.student.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lt.student.beans.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	@Modifying
	@Transactional
	@Query(value = "delete from student_Course where student_Id=:studentId and course_Id=:courseId", nativeQuery = true)
	int deleteByStudentIdAndCourseId(@Param("studentId") String studentId, @Param("courseId") String courseId);

	@Query(value = "select  sc.course_id as courseId,c.course_name as courseName,sc.grade as grade from student_course sc inner join course c on c.course_id=sc.course_id where student_Id=:studentId", nativeQuery = true)
	List<ViewGrades> findByStudentId(@Param("studentId") String studentId);
	
	@Query(value = "select sc.grade as grade, c.course_id as courseId, s.name as studentName, c.course_name as courseName from student_course sc inner join course c on c.course_id=sc.course_id inner join student s on s.student_id=sc.student_id where sc.student_id=:studentId", nativeQuery = true)
	List<GenerateReportCard> generateReportCard(String studentId);

	public interface GenerateReportCard {
		String getGrade();

		String getStudentName();

		String getCourseId();

		String getCourseName();
	}

	public interface ViewGrades {
		String getCourseId();

		String getCourseName();

		String getGrade();
	}

}
