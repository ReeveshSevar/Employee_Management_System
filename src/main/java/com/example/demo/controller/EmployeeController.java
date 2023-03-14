package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.serviceImplementation.ServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private ServiceImpl service;

	@GetMapping("/")
	public String logIn()
	{
		return "HomePage";
	}
	
	@PostMapping("/validate")
	public String val(@ModelAttribute Employee emp , Model model)
	{
		if(service.logIn(emp))
			return "Welcome";
		else
			throw new EmployeeNotFound("Employee "+emp.getEid()+" Not Found");
	}
	
	@GetMapping("/forget")
	public String forget()
	{
		return "Forget";
	}
	
	
}
