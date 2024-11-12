package com.sks.create.userdefinedclasses.forcollection;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class CustomArrayList<T> {

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size = 0;

	public CustomArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(T value) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = value;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (T) elements[index];
	}

	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		T removedElement = (T) elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size--;
		return removedElement;
	}

	private void ensureCapacity() {
		int newCapacity = elements.length * 2;
		elements = Arrays.copyOf(elements, newCapacity);
	}

	public void display() {
		System.out.print("[");
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i]);
			if (i < size - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
