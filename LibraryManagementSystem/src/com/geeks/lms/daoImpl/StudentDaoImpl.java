package com.geeks.lms.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geeks.lms.beans.StudentBean;
import com.geeks.lms.connection.DBConnection;
import com.geeks.lms.dao.StudentDao;

public class StudentDaoImpl implements StudentDao{

	Connection con = DBConnection.getConnection();
	PreparedStatement pst = null;
	@Override
	public int addStudent(StudentBean studentBean) {
		try {
			pst = con.prepareStatement("insert into student (student_name,gender,date_of_birth,issue_id,email,contact_no,cnic,address,roll_no,department_id) values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1,studentBean.getStudentName());
			pst.setString(2, studentBean.getGender());
			pst.setDate(3, studentBean.getDateOfBirth());
			pst.setInt(4, studentBean.getIssueId());
			pst.setString(5, studentBean.getEmail());
			pst.setInt(6, studentBean.getContactNo());
			pst.setInt(7, studentBean.getCnic());
			pst.setString(8, studentBean.getAddress());
			pst.setString(9, studentBean.getRollNo());
			pst.setInt(10, studentBean.getDepartmentId());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(StudentBean studentBean) {
		try {
			pst = con.prepareStatement("update student set student_name=?, gender=?, date_of_birth=?, issue_id=?, email=?, contact_no=?, cnic=?, address=?, roll_no=?, department_id=? where student_id = ?");
			pst.setString(1,studentBean.getStudentName());
			pst.setString(2, studentBean.getGender());
			pst.setDate(3, studentBean.getDateOfBirth());
			pst.setInt(4, studentBean.getIssueId());
			pst.setString(5, studentBean.getEmail());
			pst.setInt(6, studentBean.getContactNo());
			pst.setInt(7, studentBean.getCnic());
			pst.setString(8, studentBean.getAddress());
			pst.setString(9, studentBean.getRollNo());
			pst.setInt(10, studentBean.getDepartmentId());
			pst.setInt(11, studentBean.getStudentId());
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(StudentBean studentBean) {
		try {
			pst = con.prepareStatement("update student set active=? where student_id = ?");
			pst.setInt(1,0);
			pst.setInt(2,studentBean.getStudentId());
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
	}

	@Override
	public StudentBean getStudentById(Integer studentId) {
		ResultSet rst = null;
		StudentBean studentBean = null;
		try {
			pst = con.prepareStatement("select * from student where student_id = ?");
			pst.setInt(1, studentId);
			rst=pst.executeQuery();
			while(rst.next())
			{
				studentBean = new StudentBean();
				studentBean.setStudentName(rst.getString("student_name"));
				studentBean.setGender(rst.getString("gender"));
				studentBean.setDateOfBirth(rst.getDate("date_of_birth"));
				studentBean.setIssueId(rst.getInt("issue_id"));
				studentBean.setEmail(rst.getString("email"));
				studentBean.setContactNo(rst.getInt("contact_no"));
				studentBean.setCnic(rst.getInt("cnic"));
				studentBean.setAddress(rst.getString("address"));
				studentBean.setRollNo(rst.getString("roll_no"));
				return studentBean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentBean> getAllStudents() {
		List students = new ArrayList<StudentBean>();
		StudentBean studentBean = null;
		ResultSet rst = null;
		try {
			pst = con.prepareStatement("Select * from student where active = 1");
			rst = pst.executeQuery();
			while (rst.next())
			{
				studentBean = new StudentBean();
				studentBean.setStudentName(rst.getString("student_name"));
				studentBean.setGender(rst.getString("gender"));
				studentBean.setDateOfBirth(rst.getDate("date_of_birth"));
				studentBean.setIssueId(rst.getInt("issue_id"));
				studentBean.setEmail(rst.getString("email"));
				studentBean.setContactNo(rst.getInt("contact_no"));
				studentBean.setCnic(rst.getInt("cnic"));
				studentBean.setAddress(rst.getString("address"));
				studentBean.setRollNo(rst.getString("roll_no"));
				students.add(studentBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}
