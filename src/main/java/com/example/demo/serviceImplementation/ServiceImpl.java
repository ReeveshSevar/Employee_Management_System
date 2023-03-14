package com.example.demo.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.serviceinterface.ServiceInterf;

@Service
public class ServiceImpl implements ServiceInterf {

	@Autowired
	private EmployeeRepository repo;
	
	
//  For Employee Log In
	@Override
	public boolean logIn(Employee employee) {
		Employee emp = repo.findByEidAndEdobAndPwd(employee.getEid(),employee.getEdob(),employee.getPwd());
		boolean status = emp != null ? true : false;
		return status;
	}
}
