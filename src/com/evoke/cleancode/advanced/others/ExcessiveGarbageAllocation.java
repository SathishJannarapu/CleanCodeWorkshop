package com.evoke.cleancode.advanced.others;

public class ExcessiveGarbageAllocation {

	public static void main(String args[]) {
		
		String oneMillionHello = "";
		for (int i = 0; i < 1000000; i++) {
			oneMillionHello = oneMillionHello + "Hello!";
		}
		System.out.println(oneMillionHello.substring(0, 6));
		
		//In Java development, strings are immutable. So, on each iteration a new string is created. To address this we should use a mutable StringBuilder:

		StringBuilder oneMillionHelloSB = new StringBuilder();
	    for (int i = 0; i < 1000000; i++) {
	        oneMillionHelloSB.append("Hello!");
	    }
	     System.out.println(oneMillionHelloSB.toString().substring(0, 6));

	}

}
