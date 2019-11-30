package com.geeks.lms.dao;

import java.util.List;
import com.geeks.lms.beans.DepartmentBean;

public interface DepartmentDao {

	public int addDepartment(DepartmentBean departmentBean);
	public int updateDepartment(DepartmentBean departmentBean);
	public int deleteDepartment(DepartmentBean departmentBean);
	public DepartmentDao getDepartmentById(Integer departmentId);
	public List<DepartmentBean> getAllDepartments();
}
