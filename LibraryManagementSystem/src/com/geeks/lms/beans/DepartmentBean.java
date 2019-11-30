package com.geeks.lms.beans;

import java.io.Serializable;

public class DepartmentBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int departmentId;
	private String departmentName;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
