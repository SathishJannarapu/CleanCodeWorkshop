package com.evoke.cleancode.advanced.others;

public class ExcessiveGarbageAllocation {

	public static void main(String args[]) {
		
		long startTime = System.currentTimeMillis();
		System.out.println("Start time: "+ startTime);
		String oneMillionHello = "";
		for (int i = 0; i < 100000; i++) {
			oneMillionHello = oneMillionHello + "Hello!";
		}
		System.out.println(oneMillionHello.substring(0, 6));
		long endTime = System.currentTimeMillis();
		System.out.println("End time: "+ endTime);
		System.out.println("Total time in seconds: "+ (endTime - startTime)/1000);
		
		//In Java development, strings are immutable. So, on each iteration a new string is created. To address this we should use a mutable StringBuilder:

		long startTime1 = System.currentTimeMillis();
		System.out.println("Start time: "+ startTime1);
		StringBuilder oneMillionHelloSB = new StringBuilder();
	    for (int i = 0; i < 100000; i++) {
	        oneMillionHelloSB.append("Hello!");
	    }
	     System.out.println(oneMillionHelloSB.toString().substring(0, 6));
		long endTime1 = System.currentTimeMillis();
		System.out.println("End time: "+ endTime1);
		System.out.println("Total time in seconds: "+ (endTime1 - startTime1)/1000);

	}

}
