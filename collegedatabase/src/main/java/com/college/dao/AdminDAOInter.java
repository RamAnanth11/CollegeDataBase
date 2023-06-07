package com.college.dao;

import com.college.dto.Admin;

public interface AdminDAOInter {

	boolean saveAdmin(Admin admin);

	Admin adminLogin(String name,String password);

	Admin getAdminById();

	Admin deleteAdmin();

}
