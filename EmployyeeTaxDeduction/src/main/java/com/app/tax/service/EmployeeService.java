package com.app.tax.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tax.entity.Employee;
import com.app.tax.entity.TaxInfo;
import com.app.tax.repository.EmployeeRepository;

@Service
public class EmployeeService {

	/*
	 * @Autowired private IEmployyeService service; public
	 * ResponseEntity<List<Employee>> getAllEmployees1() {
	 * 
	 * List<Employee> list =service.getAllEmployees(); return new
	 * ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}
	
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	/*
	 * No Tax for <=250000
	 * 
	 * 5% Tax for >250000 and <=500000
	 * 
	 * 10% Tax for >500000 and <=1000000
	 * 
	 * 20% Tax for >1000000
	 */

	public TaxInfo calculateTax(Employee employee) {
		double yearlySalary = employee.getSalary() * 12;
		double taxAmount = 0.0;
		
		if(yearlySalary <= 250000) {
			taxAmount = 0.0;
		} else if(yearlySalary<=500000) {
			taxAmount = yearlySalary * 0.05;
		} else if(yearlySalary <= 1000000) {
			taxAmount = yearlySalary * 0.10;
		} else {
			taxAmount = yearlySalary * 0.20;
		}
		
		double cessAmount = 0.0;
		if(yearlySalary>2500000) {
			cessAmount = yearlySalary * 0.02;
		}
		
		return new TaxInfo(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount);
	}
}