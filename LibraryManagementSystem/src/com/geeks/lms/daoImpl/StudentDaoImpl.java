package com.geeks.lms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.geeks.lms.beans.StudentBean;
import com.geeks.lms.connection.DBConnection;
import com.geeks.lms.dao.StudentDao;

public class StudentDaoImpl implements StudentDao{

	Connection con = DBConnection.getConnection();
	PreparedStatement pst = null;
	@Override
	public int addStudentDetails(StudentBean studentBean) {
		try {
			pst = con.prepareStatement("Insert into student ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudentDetails(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentDetails(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentBean getStudentDetailsById(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentBean> getAllStudentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
