package com.vti.entity.generic;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
	}
	
	public V getPhoneNumber() {
		return super.getValue();
	}
	
	public K getKey() {
		return super.getKey();
	}

	@Override
	public String toString() {
		return "Phone [key=" + getKey() + ", phoneNumber=" + getPhoneNumber() + "]";
	}
}
