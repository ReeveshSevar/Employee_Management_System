package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	public Employee findByEidAndEdobAndPwd(Integer id , String edob, String pwd);

}
