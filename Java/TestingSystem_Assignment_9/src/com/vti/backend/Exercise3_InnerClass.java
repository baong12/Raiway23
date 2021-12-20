package com.vti.backend;

import com.vti.entity.Car;
import com.vti.entity.Cpu;

public class Exercise3_InnerClass {
//	Question 1:
//		Tạo class CPU có property: price
//		Tạo 2 inner class Processor, Ram
//		Với Processor có các property: coreAmount, menufacturer và
//		method getCache() và return ra 4.3
//		Với Ram có các property: memory, menufacturer và method
//		getClockSpeed() và return ra 5.5
//		Sau đó khởi tạo object CPU và in ra cache của Processor và
//		clockSpeed của Ram
	public static void question1( ) {
		System.out.println("\n--- Question 1:");
		Cpu cpu = new Cpu(20000000f);
		cpu.processor = cpu.new Processor(4, "Intel");
		cpu.ram = cpu.new Ram(2.5f, "Fpt");
		float cache = cpu.processor.getCache();
		float clockSpeed = cpu.ram.getClockSpeed();
		System.out.println(cache);
		System.out.println(clockSpeed);
	}
	
//	Question 2:
//		Tạo Car có property: name, type
//		Tạo inner class Engine có property engineType và tạo getter, setter cho
//		property engineType
//		Khởi tạo object Car có name = Mazda, type = 8WD, có loại động cơ là
//		"Crysler".
//		Sau đó in ra thông tin của động cơ
	public static void question2() {
		System.out.println("\n--- Question 2:");
		Car car = new Car("Mazda", "8WD");
		car.setEngine(car.new Engine("Crysler"));
		System.out.println(car);
		
	}
}
