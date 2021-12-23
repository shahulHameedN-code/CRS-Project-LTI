package com.lt.crs.bean;

/**
 * 
 * @author Shahul
 * Class to store Course information
 * 
 */
public class Course {

	private String name;
	private String id;
	private String grade;
	private int noOfStudents;
	private int courseFee;

	/**
	 * Default Constructor
	 */
	public Course() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param courcename:               name
	 * @param coursegrade:              grade
	 * @param courseId:                 id
	 * @param noOfStudents:noOfStudents
	 */

	public Course(String name, String id, int noOfStudents) {
		this.name = name;
		this.id = id;
		this.noOfStudents = noOfStudents;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to get name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set name
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get Id
	 * 
	 * @return Id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set Course Id
	 * 
	 * @param Id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get Grade
	 * 
	 * @return Grade
	 */

	public String getGrade() {
		return grade;
	}

	/**
	 * Method to set Grade
	 * 
	 * @param Grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Method to get NoOfStudents
	 * 
	 * @return NoOfStudents
	 */
	public int getNoOfStudents() {
		return noOfStudents;
	}

	/**
	 * Method to set NoOfStudents
	 * 
	 * @param NoOfStudents
	 */

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	/**
	 *
	 * To string
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", grade=" + grade + ", noOfStudents=" + noOfStudents + "]";
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

}
