package com.example.demo.serviceinterface;

import java.util.List;

import com.example.demo.model.Admin;
import com.example.demo.model.Employee;

public interface AServiceInterf {
	
	// For Admin LogIn
	public boolean logIn(Admin ad);
	
	// For Deleting An Employee
	void deleteEmp(Integer id);
	
	// For Updating An Employee
	void updateEmp(Employee e);

	// For Editing An Employee
	Employee editEmp(Integer id);

	// For Creating Employee
	Integer signUp(Employee emp);
	
	// For Retrive Only One Employee
	Employee getOneEmployee(Integer id);
	
	// For Retriving All Employee
	public List<Employee> getAllEmps();

	

}
