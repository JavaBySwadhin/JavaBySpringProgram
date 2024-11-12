package com.sks.create.userdefinedclasses.forcollection;

public class CustomArrayListTest {

	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);

		list.display();

		int index = 1;
		System.out.println("\nElement at index " + index + ": " + list.get(index));

	}
}
