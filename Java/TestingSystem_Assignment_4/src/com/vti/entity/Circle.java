package com.vti.entity;

public class Circle {
	private double radius = 1.0;
	private String color = "red";
	private static double pi = 3.14;
	
	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		return pi * radius * radius;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
	
	
}
