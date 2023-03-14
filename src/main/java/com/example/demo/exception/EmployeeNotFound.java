package com.example.demo.exception;

public class EmployeeNotFound extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public EmployeeNotFound() 
	{
		super();
	}
	
	public EmployeeNotFound(String message) 
	{
		super(message);
	}
	
}
