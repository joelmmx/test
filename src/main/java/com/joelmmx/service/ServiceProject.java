package com.joelmmx.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelmmx.entity.EmployeeWorkedHours;
import com.joelmmx.entity.Employees;
import com.joelmmx.repository.EmployeeWorkedHoursRepository;
import com.joelmmx.repository.EmployeesRepository;
import com.joelmmx.repository.GendersRepository;
import com.joelmmx.repository.JobsRepository;

@Service
public class ServiceProject {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private GendersRepository gendersRepository;
	
	@Autowired
	private JobsRepository jobsRepository;
	
	@Autowired
	private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
	
	public Employees saveEmployees(Employees employees) {
		return employeesRepository.save(employees);
	}
	
	public EmployeeWorkedHours saveEmployeeWorkedHours(EmployeeWorkedHours employeeWorkedHours) {
		return employeeWorkedHoursRepository.save(employeeWorkedHours);
	}
	
	public boolean existsByName(String name) {
		Set<Employees> employees = employeesRepository.findByName(name);
		return employees!=null&&employees.size()>0?true:false;
	}
	
	public boolean existsByLastName(String lastName) {
		Set<Employees> employees = employeesRepository.findByLastName(lastName);
		return employees!=null&&employees.size()>0?true:false;
	}
	
	public boolean existsGenderById(Integer id) {
		return gendersRepository.existsById(id);
	}
	
	public boolean existsJobsById(Integer id) {
		return jobsRepository.existsById(id);
	}
	
	public boolean existsEmployeeById(Integer id) {
		return employeesRepository.existsById(id);
	}
	
}
