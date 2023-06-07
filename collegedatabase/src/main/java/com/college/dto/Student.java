package com.college.dto;

public class Student {
	private Integer id;
	private String name;
	private String password;
	private String department;

	public Student() {
		super();
	}

	public Student(Integer id, String name, String password, String department) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", department=" + department + "]";
	}

}
