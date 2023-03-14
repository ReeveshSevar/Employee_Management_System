package com.example.demo.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Admin;
import com.example.demo.model.Employee;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.serviceinterface.AServiceInterf;

@Service
public class AServiceImpl implements AServiceInterf {

	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private EmployeeRepository erepo;
	
	
//  For Admin Login
	@Override
	public boolean logIn(Admin ad) {
		
		Admin admin = new Admin(1001,"Admin#123");
		repo.save(admin);
		
		
		Admin a = repo.findByAidAndApwd(ad.getAid(), ad.getApwd());
		boolean ab = a != null ? true:false;
		return ab;
	}
	
//  For Employee SignUp
	@Override
	public Integer signUp(Employee e) 
	{
		double sal = e.getEsal();
		double hra = sal*20/100;
		double da  = sal*18/100;
		
		e.setHra(hra);
		e.setDa(da);
		
		e = erepo.save(e);
		
		return e.getEid();
	}
	
// For Delete Employee
	@Override
	public void deleteEmp(Integer id) {
		Optional<Employee> opt = erepo.findById(id);
		if(opt.isPresent())
		{
			 erepo.deleteById(id);
			
		}
		else
			throw new EmployeeNotFound("Employee "+id+ " Not Exist"); 
			
	}
	
//  For Updating Employee
	@Override
	public void updateEmp(Employee e) {
		if(erepo.existsById(e.getEid()))
		{
			double sal = e.getEsal();
			double hra = sal*20/100;
			double da  = sal*18/100;
			
			e.setHra(hra);
			e.setDa(da);
			
			
			e = erepo.save(e);
		}
		else
			throw new EmployeeNotFound("Employee "+e.getEid()+" Not Found");
	}

//  For Editing Employee
	@Override
	public Employee editEmp(Integer id) {
		Optional<Employee> opt = erepo.findById(id);
		if(opt.isPresent())
		{
			Employee e = opt.get();
			return e;
		}
		else
			throw new EmployeeNotFound("Employee "+id+" Not Exist");
	}
//  For Fetching One Employee For Update Purpose
	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = erepo.findById(id);
		if(opt.isPresent())
		{
			Employee e = opt.get();
			return e;
		}
		else
			throw new EmployeeNotFound("Employee "+id+" Not Exist");
	}
	
//  For Fetching All Records
	@Override
	public List<Employee> getAllEmps() {
		return erepo.findAll();
	}

}
