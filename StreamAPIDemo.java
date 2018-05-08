package com.demo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAPIDemo {

	public static void main(String[] args) {

		//Create a new ArrayList
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(2);
		myList.add(4);
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(51);
		myList.add(100);
		
		System.out.println("Original List Is "+myList);
		
		//Obtain a Stream from this
		Stream<Integer> myStream = myList.stream();
		
		//Get Minimum and Maximum. Optional class is described in CH 20. It's a Generic class
		Optional<Integer> max = myStream.max(Integer::compare);
		if(max.isPresent()) {
			System.out.println("Max "+max.get());
		}
		
		//Sort the Stream
		Stream<Integer> sortedStream =  myList.stream().sorted();
		System.out.println("Sorted Stream ");
		sortedStream.forEach(n -> {
			System.out.println(n+" ");
		});
		System.out.println();
		
		//Odd Values
		System.out.println("Odd Nos");
		Stream<Integer> oddStream = myList.stream().filter(n -> (n%2 == 1));
		oddStream.forEach(n->System.out.println(n+""));
		
		//Odd values > 5 : use pipeline
		System.out.println("Odd Nos > 5");
		Stream<Integer> filterStream = myList.stream().filter(n -> (n%2 == 1)).filter(n -> (n > 5));
		filterStream.forEach(n -> System.out.println(n+""));
		System.out.println();
	}

}
