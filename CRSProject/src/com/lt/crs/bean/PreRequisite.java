package com.lt.crs.bean;

import java.util.List;

public class PreRequisite {

	private List<String> preRequisite;
	private Course course;

	public List<String> getPreRequisite() {
		return preRequisite;
	}

	public void setPreRequisite(List<String> preRequisite) {
		this.preRequisite = preRequisite;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
