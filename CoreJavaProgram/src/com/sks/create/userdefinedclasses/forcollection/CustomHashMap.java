package com.sks.create.userdefinedclasses.forcollection;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomHashMap<K, V> {

	private int initialCapacity = 16;
	static final float LOAD_FACTOR = 0.75f;
	private Entry<K, V>[] table;
	private int size;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public CustomHashMap() {
		table = new Entry[initialCapacity];
	}

	// Hash function to compute the index for a key
	private int hash(K key) {
		return Objects.hashCode(key) % initialCapacity;
		// return Math.abs(key.hashCode()) % initialCapacity;
	}

	public void put(K key, V value) {
		int index = hash(key);
		Entry<K, V> newEntry = new Entry<>(key, value, null);

		// Check if the bucket is empty
		if (table[index] == null) {
			table[index] = newEntry; // Insert if empty
		} else {
			// Collision handling using chaining
			Entry<K, V> current = table[index];
			while (true) {
				if (current.key.equals(key)) {
					current.value = value; // Update value if key exists
					return;
				}
				if (current.next == null) {
					current.next = newEntry; // Add new entry at the end
					break;
				}
				current = current.next; // Move to the next entry
			}
		}
		size++;
		// Resize if load factor threshold exceeded
		if ((float) size / initialCapacity > LOAD_FACTOR) {
			resize();
		}
	}

	public V get(K key) {
		int index = hash(key);
		Entry<K, V> current = table[index];
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value; // Return value if key found
			}
			current = current.next; // Move to the next entry
		}
		return null; // Return null if key not found
	}

	// Method to remove a key-value pair
	public V remove(K key) {
		int index = hash(key);
		Entry<K, V> current = table[index];
		Entry<K, V> previous = null;

		while (current != null) {
			if (current.key.equals(key)) {
				if (previous == null) {
					table[index] = current.next; // Remove the first entry
				} else {
					previous.next = current.next; // Bypass the current entry
				}
				size--;
				return current.value; // Return the removed value
			}
			previous = current; // Keep track of the previous entry
			current = current.next; // Move to the next entry
		}
		return null; // Return null if key not found
	}

	// Resize the hash map when the load factor threshold is exceeded
	private void resize() {
		Entry<K, V>[] oldTable = table;
		initialCapacity *= 2; // Double the initialCapacity
		table = new Entry[initialCapacity];
		size = 0;

		for (Entry<K, V> entry : oldTable) {
			while (entry != null) {
				put(entry.key, entry.value); // Rehash entries into new table
				entry = entry.next;
			}
		}
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean firstEntry = true;

		for (int i = 0; i < initialCapacity; i++) {
			Entry<K, V> current = table[i];
			while (current != null) {

				if (!firstEntry) {
					sb.append(", ");
				}
				sb.append(current.key).append("=").append(current.value);
				current = current.next;
				firstEntry = false;
			}
		}

		sb.append("}");
		System.out.println(sb.toString());
	}

}
