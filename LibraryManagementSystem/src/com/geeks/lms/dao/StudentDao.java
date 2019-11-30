package com.geeks.lms.dao;

import java.util.List;
import com.geeks.lms.beans.StudentBean;

public interface StudentDao {

	public int addStudentDetails(StudentBean studentBean);
	public int updateStudentDetails(StudentBean studentBean);
	public int deleteStudentDetails(StudentBean studentBean);
	public StudentBean getStudentDetailsById(Integer studentId);
	public List<StudentBean> getAllStudentDetails();
}
