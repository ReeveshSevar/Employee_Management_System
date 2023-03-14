package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Employee;
import com.example.demo.serviceinterface.AServiceInterf;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AServiceInterf service;
	
	@GetMapping("/login")
	public String logIn()
	{
		return "AdminLogIn";
	}
	
	@PostMapping("/adminval")
	public String getAccess(@ModelAttribute Admin admin)
	{
		if(service.logIn(admin))
			
			return "redirect:show";
		else
			throw new AdminNotFoundException("Admin Not Found");
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "EmpReg";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute Employee employee,Model model)
	{
		service.signUp(employee);
		
		model.addAttribute("msg", "Employee Data Created");
		return "EmpReg";
	}
	
	@GetMapping("/show")
	public String empAccess(Model model)
	{
		List<Employee> list = service.getAllEmps();
		model.addAttribute("list", list);
		return "EmpData";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer eid , Model model)
	{
		System.err.println(eid);
		service.deleteEmp(eid);
		return "redirect:show";
	}
	
  
	@GetMapping("/edit")
	public String edit(@RequestParam Integer eid , Model model)
	{
		Employee emp = service.getOneEmployee(eid);
		model.addAttribute("employee",emp);
		return "EmpEdit";
	}
	
  
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employee)
	{
		service.updateEmp(employee);
		return "redirect:show";
	}
	
}
