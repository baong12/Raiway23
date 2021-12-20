package com.vti.frontend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.vti.entity.SinhVien;

public class Demo {
	public static void main(String[] args) {
		ArrayList<SinhVien> svArray = new ArrayList<SinhVien>();
		svArray.add(new SinhVien(1, "Nguyen Van A"));
		svArray.add(new SinhVien(2, "Nguyen Van B"));
		svArray.add(new SinhVien(3, "Nguyen Van C"));
		svArray.add(new SinhVien(4, "Nguyen Van D"));
		svArray.add(new SinhVien(5, "Nguyen Van D"));
		svArray.add(new SinhVien(6, "Nguyen Van D"));
		svArray.add(new SinhVien(7, "Nguyen Van E"));
		
		Optional<SinhVien> matchingObject = svArray.stream().
			    filter(p -> p.getName().equals("Nguyen Van D")).
			    findFirst();
		SinhVien person = matchingObject.get();
		
		// Stream API Java (Java 8)
		SinhVien sinhVien = svArray.stream().
			    filter(p -> p.getName().equals("Nguyen Van D")).
			    findAny().get();
		System.out.println(person);
		
		Set<String> names = 
				svArray.stream() 
			           .map(SinhVien::getName) //SinhVien::getName <- delegate
			           .sorted(Comparator.reverseOrder())
			           .collect(Collectors.toSet());
		System.out.println(names);
		
		String name = svArray.stream()
				.filter(p -> p.getId() == 1)
				.findFirst()
				.get()
				.getName();
		System.out.println(name);

//		Map<Integer, String> names = new HashMap<Integer, String>();
	}
}


