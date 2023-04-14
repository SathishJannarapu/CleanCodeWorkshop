package com.evoke.cleancode.basic;

import com.evoke.cleancode.domains.Laptop;

public class BasicPoints {

	public static void main(String[] args) {
		
		//1. Avoid poor naming
			// Short variable names
			String an;
		    // Long Variable Names
				// Person[] peopleFromIndiaWhoCanSpeakFrench;
		    // Bad Notations
			int iSize;   String sName;
	}
	
	//3. Create proper method signatures
	Laptop getPerson(String ownerId){
		//do something
		
		return new Laptop();
	}
	
	void parse(int myNumber) {}
	void getName() {}
	
	// 4.Keep method parameter count to a minimum
	void myMethod(int param1, String param2, float param3, int param4, String param5) {} 
	
	// 5.	Declare variable at the place of use
	void myMethod(Laptop laptop) {
  		 String a,b,c;
   		//after 25 lines...
   		a = laptop.getName();
	}


	
	 

}
