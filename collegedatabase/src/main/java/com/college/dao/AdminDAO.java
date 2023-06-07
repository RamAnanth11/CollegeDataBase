package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.college.dto.Admin;
import com.college.util.CollegeUtil;

public class AdminDAO implements AdminDAOInter {
	Connection con = null;

	public boolean saveAdmin(Admin admin) {
		con = CollegeUtil.getConnection();
		String query = "INSERT INTO ADMIN VALUES (?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getDepartment());
			
			boolean execute = ps.execute();
			
			con.close();
			return execute;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Admin adminLogin(String name, String password) {
		con = CollegeUtil.getConnection();
		String query  = "SELECT * FROM ADMIN WHERE name = ? and password = ?";
		Admin admin = null;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2,  password);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				admin = new Admin();
				admin.setId(set.getInt(1));
				admin.setName(set.getString(2));
				admin.setPassword(set.getString(3));
				admin.setDepartment(set.getString(4));
			}
			return admin;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public Admin getAdminById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Admin> getAllAdmin()
	{
		con = CollegeUtil.getConnection();
		List<Admin> list = null;
		String query = "SELECT * FROM ADMIN";
		try {
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery(query);
			if(set.isBeforeFirst())
			{
				list = new ArrayList<Admin>();
				while(set.next())
				{
					Admin admin = new Admin();
					admin.setId(set.getInt(1));
					admin.setName(set.getString(2));
					admin.setPassword(set.getString(3));
					admin.setDepartment(set.getString(4));
					list.add(admin);
				}
			}
			return list;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		return null;
	}
	
	public Admin deleteAdmin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Admin admin = new Admin(2, "Ram", "4321", "Master");
		AdminDAO dao = new AdminDAO();
		System.out.println(dao.saveAdmin(admin));
		
//		System.out.println(dao.adminLogin("ananth","1234"));
		
		List<Admin> allAdmin = dao.getAllAdmin();
		for(Admin a : allAdmin)
			System.out.println(a);
		
	}

}
