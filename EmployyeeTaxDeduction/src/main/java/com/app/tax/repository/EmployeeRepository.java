package com.app.tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tax.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
