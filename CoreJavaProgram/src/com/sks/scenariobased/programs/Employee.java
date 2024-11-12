package com.sks.scenariobased.programs;

public class Employee {

	private Integer empId;
	private String empName;
	private Integer empAge;
	private String gender;
	private Department department;
	private Integer yearOfJoining;
	private double empSalary;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(Integer yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public Employee(Integer empId, String empName, Integer empAge, String gender, Department department,
			Integer yearOfJoining, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", gender=" + gender
				+ ", department=" + department + ", yearOfJoining=" + yearOfJoining + ", empSalary=" + empSalary + "]";
	}

}
