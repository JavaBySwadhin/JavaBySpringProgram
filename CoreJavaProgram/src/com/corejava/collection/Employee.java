package com.corejava.collection;

import java.util.Objects;

public class Employee {
	
	private String name;
	
	public Employee(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Employee employee = (Employee) o;
	    return name.equals(employee.name);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(name);
	}
	
	/*
	 * if we comment equals and hashCode method then see the output
	 */


}
