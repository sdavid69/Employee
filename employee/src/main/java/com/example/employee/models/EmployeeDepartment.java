package com.example.employee.models;

public class EmployeeDepartment {
	private String departmentId;
	private String departmentLocation;
	private String error;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public EmployeeDepartment(String departmentId, String departmentLocation) {
		super();
		this.departmentId = departmentId;
		this.departmentLocation = departmentLocation;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
}
