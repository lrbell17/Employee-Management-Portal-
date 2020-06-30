package com.entity;

public class Employee {
	private int empId;
	private String name;
	private String email;
	private String password;
	private String country;
	
	public Employee(int empId, String name, String email, String password, String country) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}
	public Employee() {
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", country=" + country + "]";
	}
	
	
}
