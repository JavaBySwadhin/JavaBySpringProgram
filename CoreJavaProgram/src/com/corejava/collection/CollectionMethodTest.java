package com.corejava.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMethodTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Raja");
		list.add("Rani");
		list.add("Ramiya");
		System.out.println("Display base list data: " + list);

		// add one more string data
		list.add("Ramesh");
		System.out.println("Display modified list data: " + list);

		// get the particular data present in index 0
		System.out.println("Display element present at index 0:" + list.get(0));
		// remove one element
		String s = list.remove(0);
		System.out.println("Display remove element from list:" + s);

		boolean containsFlag = list.contains("Rani"); // Case is taken into consideration

		System.out.println("Raja present in list or not?" + containsFlag);

		boolean containsFlag1 = list.contains("rani");
		System.out.println("Raja present in list or not?" + containsFlag1);

		// Add again "Raja" in list
		list.add("Raja");

		filterCheck(list);
		//check(list);

		List<String> list1 = new ArrayList<>();
		list1.add("test1");
		list1.add("test2");
		list1.add("test3");

		List<String> list2 = new ArrayList<>();
		list2.add("test4");
		list2.add("test5");
		list2.add("test3");
		
		list2.stream().filter(l2-> list1.contains(l2)).forEach(System.out::println);
		
			
		List<String> list3 = new ArrayList<>(); 
		list3.add("a");
		list3.add("b");
		list3.add("c");
		
		
		List<String> list4 = new ArrayList<>();
		list4.add("b");
		list4.add("c");
		list4.add("d");
		list4.add("e");
		
		boolean addAll = list3.addAll(list4);
		System.out.println(addAll);
		System.out.println("List3 data: "+list3);
		System.out.println("List4 data:"+list4);
		List<String> collect = list3.stream().distinct()
		.collect(Collectors.toList());
		System.out.println(collect);
		
		
		List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        List<String> collect2 = names.stream().distinct().collect(Collectors.toList());
        System.out.println(collect2);
		
}


	private static void filterCheck(List<String> nameList) {
		nameList.stream()
		.peek(l -> System.out.println("Checking: " + l))
		.filter(l -> l.contains("Raja"))
		.forEach(System.out::println);
	}
	
	

}
