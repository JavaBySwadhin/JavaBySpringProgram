package com.corejava.collection;

import java.util.HashSet;
import java.util.Set;

public class EmployeeTest {

	public static void main(String[] args) {
	
		Employee emp1 = new Employee("Swadhin");
		Employee emp2 = new Employee("Swadhin");
		
		Set<Employee> set = new HashSet<>();
		
		set.add(emp1);
		set.add(emp2);
		
		System.out.println(set);
		
		
		

	}

}
