package com.geeks.lms.dao;

import java.util.List;
import com.geeks.lms.beans.StudentBean;

public interface StudentDao {

	public int addStudent(StudentBean studentBean);
	public int updateStudent(StudentBean studentBean);
	public int deleteStudent(StudentBean studentBean);
	public StudentBean getStudentById(Integer studentId);
	public List<StudentBean> getAllStudents();
}
