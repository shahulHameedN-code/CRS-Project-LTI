package com.lt.crs.intrfc;

import com.lt.crs.bean.StudentRegistration;

public interface StudentRegisterDao {

	public void saveStudentRegister(StudentRegistration register);

	public void passwordRegisteration(StudentRegistration register);

}
