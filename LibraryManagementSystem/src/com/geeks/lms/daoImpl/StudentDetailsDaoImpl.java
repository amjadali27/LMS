package com.geeks.lms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geeks.lms.beans.DepartmentBean;
import com.geeks.lms.beans.StudentDetailsBean;
import com.geeks.lms.connection.DBConnection;
import com.geeks.lms.dao.DepartmentDao;
import com.geeks.lms.dao.StudentDetailsDao;

public class StudentDetailsDaoImpl implements StudentDetailsDao{

	Connection con = DBConnection.getConnection();
	@Override
	public List<StudentDetailsBean> getAllStudentDetails() {
		List students = new ArrayList<StudentDetailsBean>();
		StudentDetailsBean student = null;
		DepartmentDao department = null;
		try {
			PreparedStatement pst = con.prepareStatement("Select * from student_details where active=?");
			pst.setString(1, "1");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				student = new StudentDetailsBean();
				department = new DepartmentDaoImpl().getDepartmentById(rs.getInt("department_id"));
				student.setStudentId((rs.getInt("student_id")));
				student.setStudentName(rs.getString("student_name"));
				student.setGender(rs.getString("gender"));
				student.setDateOfBirth(rs.getDate("date_of_birth"));
				student.setEmail(rs.getString("email"));
				student.setContactNo(rs.getInt("contact_no"));
				student.setCnic(rs.getInt("cnic"));
				student.setAddress(rs.getString("address"));
				student.setRollNo(rs.getString("roll_no"));
				student.setDepartmentBean(department););
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public int addStudentDetails(StudentDetailsBean studentDetailsBean) {
		try{
			PreparedStatement pst = con.prepareStatement("Insert into student(name,gender,email,roll_number,active) values(?,?,?,?,?)");
			pst.setString(1,student.getStudentName());
			pst.setString(2, student.getGender());
			pst.setString(3, student.getEmail());
			pst.setString(4, student.getRollNumber());
			pst.setString(5, "1");
			return pst.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	@Override
	public int updateStudentDetails(StudentDetailsBean studentDetailsBean) {
		try{
			PreparedStatement pst = con.prepareStatement("Update student set name=?,gender=?,email=?,roll_number=? where student_id=?");
			pst.setString(1,student.getStudentName());
			pst.setString(2, student.getGender());
			pst.setString(3, student.getEmail());
			pst.setString(4, student.getRollNumber());
			pst.setInt(5, student.getStudentId());
			return pst.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	@Override
	public int deleteStudentDetails(StudentDetailsBean studentDetailsBean) {
		try{
			PreparedStatement pst = con.prepareStatement("Update student set active=? where student_id=?");
			pst.setString(1, "0");
			pst.setInt(2, student.getStudentId());
			return pst.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	@Override
	public StudentDetailsBean getStudentDetailsById(Integer studentDetailsId) {
		StudentBean student = null;
		try{
			PreparedStatement pst = con.prepareStatement("Select * from student where student_id=?");
			pst.setInt(1, studentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				student = new StudentBean();
				student.setStudentId(studentId);
				student.setStudentName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setEmail(rs.getString("email"));
				student.setRollNumber(rs.getString("roll_number"));
				return student;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return student;
	}
}
