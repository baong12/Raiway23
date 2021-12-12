package com.vti.entity;

public class MyMath {
	public static int max(int a, int b) {
		return a >= b ? a : b;
	}

	public static int max(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	public static int min(int a, int b) {
		return a <= b ? a : b;
	}

	public static int min(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += i;
		}
		return sum;
	}
}
