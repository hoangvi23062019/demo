package com.poly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.poly.model.student;

public class StreamAPI {
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
		demo4();
	}

	private static void demo4() {
		// TODO Auto-generated method stub
		double average = list.stream()
				.mapToDouble(sv ->  sv.getMarks())
				.average().getAsDouble();
		System.err.println("average: "+average);
		double sum = list.stream()
				.mapToDouble(sv -> sv.getMarks())
				.sum();
		System.out.println("Sum: "+sum);
		double min_marks = list.stream()
				.mapToDouble(sv -> sv.getMarks())
				.min().getAsDouble();
		System.out.println("min: "+min_marks);
		boolean all_passed = list.stream().allMatch(sv -> sv.getMarks() >=5);
		System.out.println("all_passed: "+all_passed);
		student min_sv = list.stream()
				.reduce(list.get(0), (min,sv) -> sv.getMarks() < min.getMarks() ? sv:min);
		System.out.println("min_sv: "+min_sv);
	}

	private static void demo3() {
		// TODO Auto-generated method stub
		List<student> a = list.stream()
				.filter(sv -> sv.getMarks() >=7)
				.peek(sv -> sv.setName(sv.getName().toUpperCase()))
				.collect(Collectors.toList());
		a.forEach(n ->{
			System.out.println("name: "+n.getName());
			System.out.println("marks: "+n.getMarks());
			System.out.println();
		});
	}

	private static void demo2() {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,9,4,5,7,2);
		List<Double> a = list.stream()
				.filter(n -> n%2==0 )
				.map(n -> Math.sqrt(n))
				.peek(d -> System.out.println(d))
				.collect(Collectors.toList());
	}

	private static void demo1() {
		// TODO Auto-generated method stub
		Stream<Integer> stream1 = Stream.of(1,9,4,5,7,2);
		stream1.forEach(n -> {
			System.out.println(n);
		});
		List<Integer> list = Arrays.asList(1,9,4,5,7,2);
		list.stream().forEach(n->{
			System.out.println(n);
		});
	}
}
