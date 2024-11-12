package com.sks.create.userdefinedclasses.forcollection;

public class CustomHashMapTest {
	
	public static void main(String[] args) {
		CustomHashMap<Integer, String> map = new CustomHashMap<>();
		
        // Adding key-value pairs
        map.put(1, "Swadhin");
        map.put(2, "Swadhin");
        map.put(3, "John");
        map.put(2, "Doe"); // Update the value for key 2

        // Displaying the map
        map.display();

        // Retrieving a value
        System.out.println("Get value for key:" + map.get(1));

        // Removing a key-value pair
        System.out.println("Removed value for key:" + map.remove(2));
        map.display();
    }

}
