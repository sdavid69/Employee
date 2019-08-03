package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.employee.exceptions.DepartmentNotFoundException;
import com.example.employee.models.EmployeeDepartment;

@Component
public interface DepartmentService {
	public List<EmployeeDepartment> getAllDepartments();
	public EmployeeDepartment getDepartment(String department) throws Exception;
	public String getPersonalDetails() throws Exception;
}
