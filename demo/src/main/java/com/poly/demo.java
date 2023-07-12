package com.poly;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.poly.model.student;

public class demo {
	static List<student> list = Arrays.asList(
			new student("Nguyễn văn a", true, 10.0),
			new student("Nguyễn văn b", true, 5.0),
			new student("Nguyễn văn c", false, 4.0),
			new student("Nguyễn văn d", false, 6.0),
			new student("Nguyễn văn e", true, 8.0)
		);
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demoe4();
	}

	private static void demoe4() {
		// TODO Auto-generated method stub
		Demo4 o = (x) -> {
			System.out.println(x);
		};
		o.m1(2022);
	}

	private static void demo3() {
		// TODO Auto-generated method stub
		Collections.sort(list,(sv1,sv2)-> sv1.getMarks().compareTo(sv2.getMarks()));
		list.forEach(sv -> {
			System.out.println("name: "+ sv.getName());
			System.out.println("marks: "+sv.getMarks());
			System.out.println();
		});
	}

	private static void demo2() {
		// TODO Auto-generated method stub
		
		list.forEach(sv -> {
			System.out.println("Name: "+ sv.getName());
			System.out.println("Marks "+sv.getMarks());
			System.out.println();
		});
	}

	private static void demo1() {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4);
		list.forEach(n -> System.out.println(n));
	}
}
@FunctionalInterface
interface Demo4{
	void m1(int t);
	default void m2() {};
	public static void m3 () {};
}
