package com.sks.scenariobased.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		List<Employee> employeeList = employeeData();

		maleAndFemaleCount(employeeList);
		printDepartmentName(employeeList);
		averageAgeOfGender(employeeList);
		highestPaidEmployee(employeeList);
		fetchEmployeeNameWhereJoinDateAfter(employeeList);
	}

	private static void fetchEmployeeNameWhereJoinDateAfter(List<Employee> employeeList) {
		List<String> listEmpList = employeeList.stream().filter(e-> e.getYearOfJoining()>2015).map(Employee::getEmpName).collect(Collectors.toList());
		System.out.println(listEmpList);
	}

	private static List<Employee> employeeData() {
		List<Employee> employeeList = new ArrayList<>();

		Department hrDepartment = new Department(100, "HR");
		Department salesAndMarketing = new Department(200, "Sales And Marketing");
		Department infrastructure = new Department(300, "Infrastructure");
		Department productDevelopment = new Department(400, "Product Development");
		Department securityAndTransport = new Department(500, "Security And Transport");
		Department accountAndFinance = new Department(600, "Account And Finance");

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", hrDepartment, 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", salesAndMarketing, 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", infrastructure, 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", productDevelopment, 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", hrDepartment, 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", securityAndTransport, 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", accountAndFinance, 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", productDevelopment, 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", salesAndMarketing, 2016, 11500.0));
		return employeeList;
	}
	
	private static void highestPaidEmployee(List<Employee> empList) {
		Optional<Employee> empOptional = empList.stream().max(Comparator.comparing(Employee::getEmpSalary));
		if (empOptional.isPresent()) {
			System.out.println(empOptional.get().getEmpSalary());
		}
	}
	
	private static void averageAgeOfGender(List<Employee> empList) {
		Map<String, Double> avgAgeOfGender = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getEmpAge)));
		System.out.println(avgAgeOfGender);
	}

	private static void printDepartmentName(List<Employee> empList) {
		List<String> listOfDeptNames = empList.stream().map(Employee::getDepartment).map(Department::getDeptName)
				.distinct().collect(Collectors.toList());
		System.out.println(listOfDeptNames);

	}
	private static void maleAndFemaleCount(List<Employee> empList) {
		Map<String, Long> maleAndFemaleNumberOfCount = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(maleAndFemaleNumberOfCount);
	}

}
