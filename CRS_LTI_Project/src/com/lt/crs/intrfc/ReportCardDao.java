package com.lt.crs.intrfc;

import java.util.List;

import com.lt.crs.bean.Student;

public interface ReportCardDao {

	public List<Student> fetchAndGenerateReport();

	public void closeConnection();

}
