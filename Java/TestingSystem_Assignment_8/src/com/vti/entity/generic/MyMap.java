package com.vti.entity.generic;

public class MyMap<K, V> {
	private K key;
	private V value;
	
	/**
	 * @param key
	 * @param value
	 */
	public MyMap(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
