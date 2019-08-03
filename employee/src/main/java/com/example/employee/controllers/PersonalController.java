package com.example.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.employee.exceptions.DepartmentNotFoundException;
import com.example.employee.models.EmployeeDepartment;
import com.example.employee.service.DepartmentService;
/**
 * 
 *   @author Dave
 *	Dev date 4th August 2019
 */
@Controller
public class PersonalController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<EmployeeDepartment> getAllEmployees() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/personal")
	@ResponseBody
	public String getPersonalDetails() {
		String result="";
		try {
			result = departmentService.getPersonalDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = e.getMessage();
			System.out.println(result);
			e.printStackTrace();
		}finally {
			return result;			
		}
	}
	
	@GetMapping("/getDepartment/{id}")
	@ResponseBody
	public EmployeeDepartment getDepartment(@PathVariable("id") String id) {
		EmployeeDepartment ed = null;
		String errorMessage = null;
		try {
			ed = departmentService.getDepartment(id);
		} catch (DepartmentNotFoundException e) {			
			errorMessage = e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {			
			errorMessage = e.getMessage();
			e.printStackTrace();
		}finally {
			if(null == ed) {
				ed = new EmployeeDepartment(null,null);
				ed.setError(errorMessage);
			}
			return ed;			
		}
	}
}
