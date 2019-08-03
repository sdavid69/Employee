package com.example.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employee.models.EmployeeDepartment;
import com.example.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	EmployeeDepartment employeeDepartment1 = new EmployeeDepartment("HR","New South Wales");
	EmployeeDepartment employeeDepartment2 = new EmployeeDepartment("Admin","Sidney");
	List<EmployeeDepartment> departmentList = new ArrayList<>();
	
	@Override
	public List<EmployeeDepartment> getAllDepartments() {
		departmentList.add(employeeDepartment1);
		departmentList.add(employeeDepartment2);

		return departmentList;
	}
	
	@Override
	public EmployeeDepartment getDepartment(String department) throws Exception {
		EmployeeDepartment ed = null;
		if(department.equalsIgnoreCase(employeeDepartment1.getDepartmentId())) {
			ed = employeeDepartment1;
		}else if(department.equalsIgnoreCase(employeeDepartment2.getDepartmentId())) {
			ed = employeeDepartment2;
		}else {
			throw new Exception("I don't know what went wrong");//DepartmentNotFoundException("No such department exists");
		}
		return ed;
	}
	
	public String getPersonalDetails() throws Exception{
		String result="";
		RestTemplate restTemplate = new RestTemplate();
		result = restTemplate.getForObject("http://localhost:9001/all", String.class);
		return result;
	}
}
