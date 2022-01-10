package com.lt.crs.business;

import java.util.Formatter;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.dao.ReportCardDaoImpl;
import com.lt.crs.exception.ReportCardException;
import com.lt.crs.intrfc.ReportCard;

/**
 * 
 * @author Shahul Report card service
 * 
 */
public class ReportCardService implements ReportCard {

	private static Logger log = Logger.getLogger(ReportCardService.class);

	/**
	 * Method to generateReportcard for students
	 * 
	 * 
	 * 
	 * 
	 */

	public void generateReportCard() throws ReportCardException {
		log.debug("Entering generate report card");
		final Formatter fmt = new Formatter();
		System.out.println("Welcome students Report Card");
		System.out.println();
		System.out.println();

		ReportCardDaoImpl rcd = new ReportCardDaoImpl();

		List<Student> studentList = rcd.fetchAndGenerateReport();
		fmt.format("%15s %15s  %15s  %15s  %15s \n", "Student Name", "Student Id", "Course Id", "Course Name", "Grade");
		studentList.forEach(s -> {

			s.getCourseList().forEach(c -> {

				fmt.format("%14s %14s %16s %18s %14s \n", s.getName() + "|", s.getId() + "|", c.getId() + "|",
						c.getName() + "|", c.getGrade());

			});

		});
		System.out.println(fmt);

		System.out.println("---------------------------------------------------------------");

		rcd.closeConnection();
		log.debug("returning from generate report card");

	}

}
