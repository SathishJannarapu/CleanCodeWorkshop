package com.evoke.cleancode.advanced.others;

import java.util.ArrayList;
import java.util.List;

public class RawType {

	public static void main(String args[]) {
		
		List listOfNumbers = new ArrayList();
		listOfNumbers.add(10);
		listOfNumbers.add("Twenty");
		listOfNumbers.forEach(n -> System.out.println((int) n * 2));
		
		List<Integer> listOfNumbers1 = new ArrayList<>();

		listOfNumbers1.add(10);
		//listOfNumbers1.add("Twenty");

		listOfNumbers1.forEach(n -> System.out.println((int) n * 2));
		//The only difference from the original is the line defining the collection:


	}

}
