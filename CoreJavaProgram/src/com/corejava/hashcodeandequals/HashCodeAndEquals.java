package com.corejava.hashcodeandequals;

import java.util.HashSet;
import java.util.Set;

public class HashCodeAndEquals {

	public static void main(String[] args) {
		String s1 = new String("Swadhin");
		String s2 = new String("Swadhin");
		
		Set<String> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		
		System.out.println("Value:"+set);
		/*
		 * Output: Value:[Swadhin]
		 */

	}

}
