package com.geeks.lms.dao;

import java.util.List;
import com.geeks.lms.beans.StudentDetailsBean;

public interface StudentDetailsDao {

	public int addStudentDetails(StudentDetailsBean studentDetailsBean);
	public int updateDepartment(StudentDetailsBean studentDetailsBean);
	public int deleteDepartment(StudentDetailsBean studentDetailsBean);
	public StudentDetailsBean getStudentDetailsById(Integer studentDetailsId);
	public List<StudentDetailsBean> getAllStudentDetails();
}
