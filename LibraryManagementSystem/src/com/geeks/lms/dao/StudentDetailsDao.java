package com.geeks.lms.dao;

import java.util.List;
import com.geeks.lms.beans.StudentDetailsBean;

public interface StudentDetailsDao {

	public int addStudentDetails(StudentDetailsBean studentDetailsBean);
	public int updateStudentDetails(StudentDetailsBean studentDetailsBean);
	public int deleteStudentDetails(StudentDetailsBean studentDetailsBean);
	public StudentDetailsBean getStudentDetailsById(Integer studentDetailsId);
	public List<StudentDetailsBean> getAllStudentDetails();
}
