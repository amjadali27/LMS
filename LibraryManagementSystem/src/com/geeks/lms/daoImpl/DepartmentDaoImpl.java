package com.geeks.lms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.geeks.lms.beans.DepartmentBean;
import com.geeks.lms.connection.DBConnection;
import com.geeks.lms.dao.DepartmentDao;

public class DepartmentDaoImpl implements DepartmentDao {

	Connection con = DBConnection.getConnection();
	PreparedStatement pst = null;
	@Override
	public int addDepartment(DepartmentBean departmentBean) {
		try {
			pst = con.prepareStatement("Insert into department (dname) values(?)");
			pst.setString(1, departmentBean.getDepartmentName());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateDepartment(DepartmentBean departmentBean) {
		try {
			pst = con.prepareStatement("Update department set dname=? where department_id=?");
			pst.setString(1, departmentBean.getDepartmentName());
			pst.setInt(2, departmentBean.getDepartmentId());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteDepartment(DepartmentBean departmentBean) {
		try {
			pst = con.prepareStatement("Update department set active=? where department_id=?");
			pst.setInt(1, 0);
			pst.setInt(2, departmentBean.getDepartmentId());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public DepartmentBean getDepartmentById(Integer departmentId) {
		DepartmentBean departmentBean = null;
		try {
			pst = con.prepareStatement("Select * from department where department_id=?");
			pst.setInt(1, departmentId);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				departmentBean = new DepartmentBean();
				departmentBean.setDepartmentName(rst.getString("dname"));
				return departmentBean;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DepartmentBean> getAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
