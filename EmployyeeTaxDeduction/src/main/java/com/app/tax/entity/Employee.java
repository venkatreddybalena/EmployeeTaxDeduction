package com.app.tax.entity;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EmployeeID;
	@NotBlank(message="FirstName is mandatory")
    private String FirstName;

	private String LastName;
	@NotEmpty
	private String Email;

	private List<String> PhoneNumber;
	private LocalDate DOJ;
	
	private Double Salary;
	public Integer getEmployeeID() {https://github.com/venkatreddybalena/EmployyeeTaxDeduction.git
		return EmployeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<String> getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(List<String> phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public LocalDate getDOJ() {
		return DOJ;
	}
	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", PhoneNumber=" + PhoneNumber + ", DOJ=" + DOJ + ", Salary=" + Salary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(DOJ, Email, EmployeeID, FirstName, LastName, PhoneNumber, Salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(DOJ, other.DOJ) && Objects.equals(Email, other.Email)
				&& Objects.equals(EmployeeID, other.EmployeeID) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(PhoneNumber, other.PhoneNumber)
				&& Objects.equals(Salary, other.Salary);
	}
	
}
