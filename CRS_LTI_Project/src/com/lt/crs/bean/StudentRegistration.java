package com.lt.crs.bean;

public class StudentRegistration {

	/**
	 * 
	 * @author Bhuvaneshwari
	 *  StudentRegistration Class
	 * 
	 */

	private String name;
	private String id;
	private String address;
	private String userId;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param studentname:      name
	 * @param studentId:        id
	 * @param studentAddress:   Address
	 * @param password:password
	 */

	public StudentRegistration(String name, String id, String address, String password) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.password = password;
	}

	/**
	 * constructor
	 * 
	 */

	public StudentRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * toString() method
	 * 
	 */

	@Override
	public String toString() {
		return "StudentRegisteration [name=" + name + ", id=" + id + ", address=" + address + ", password=" + password
				+ "]";
	}

}
