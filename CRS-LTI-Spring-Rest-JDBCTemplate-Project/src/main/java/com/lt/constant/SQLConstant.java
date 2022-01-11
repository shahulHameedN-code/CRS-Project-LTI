package com.lt.constant;

public class SQLConstant {
	public static final String VIEW_ENROLLED_STUDENT = "select s.* from student s inner join studentcourse sc on s.id=sc.student_id where sc.course_id=?";
	public static final String ADD_GRADES = "update studentcourse sc set grade=? where sc.student_id=? and sc.course_id=?";
	public static final String REGISTER_STUDENT = "insert into student(name,id,address,email) values(?,?,?,?)";
	public static final String REGISTER_USER = "insert into user(username,password,userId,isApproved) values (?,?,?,?)";
	public static final String ADD_COURSE = "insert into studentCourse(student_id,course_id) values(?,?)";
	public static final String DELETE_COURSE = "delete from studentcourse where student_id=? and course_id=? ";
	public static final String VIEW_LIST_COURSES = "select * from course";
	public static final String VIEW_GRADES = "select * from studentcourse sc inner join course c on c.course_id=sc.course_id where sc.student_id=? ";

	public static final String MAKE_PAYMENT = "insert into payment(paymentId, studentId, totalAmount) values(?,?,?)";
	public static final String FETCH_PAYMENT = "select * from payment where studentId =?";
	public static final String DELETE_COURSE_ADMIN = "delete from course WHERE course_id=?";
	public static final String ADD_COURSE_DETAILS = "insert into course(course_id,course_name,noofstudents,paymentfee) values(?,?,?,?)";
	public static final String ADD_PROFESSOR = "insert into professor(id,name) values(?,?)";
	public static final String APPROVED_STUDENT = "update user set isApproved=true where userid=?";
}
/*
 * String sql = "insert into student(name,id,address,email) values(?,?,?,?)";
 * String userSql =
 * "insert into user(username,password,userId,isApproved) values (?,?,?,?)";
 * String sql = "insert into studentCourse(student_id,course_id) values(?,?)";
 */