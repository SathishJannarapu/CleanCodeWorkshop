package com.evoke.cleancode.basic;

public class NestedConditions {

	public static void main(String args[]) {
		Boolean a = true;
		Boolean b = true;
		Boolean c = true;
		Boolean d = true;
		String state = "";
		if(a = true){
	   		 if(b = true){
	       			 state = "Active";
	   		 } else {
	      			state = "Cancel";
	    		} 
		} else if(c = true){
	  		  if(b = true){
	        			state = "Active";
	    		} else {
	      			state = "Cancel";
	   		 } 
		} else {
	    		state = "Cancel";
		}
		
		//Multiple nested conditions make it hard to read your code. Always try to simplify them. Above code can be simplified as below,
		if(b = true && (a = true || c = true)){
		    state = "Active";
		} else {
		    state = "Cancel";
		}
		
		//Also using ternary operators is a good practice,
		state = (b = true && (a = true || c = true)) ? "Active" : "Cancel";

		//Keep in mind not to go overboard with combining conditions or ternary operators.
		if(a = true && b = true || (c = true || a = true) && d != a && c != d && (d = true || c = true) ){
		}
		
		//or multiple nested ternary operators,
		state = (b = true && (a = true || c = true)) ? (c = true || a = true) && d ? "Active" : "Modify" : "Cancel";
		
		//Instead of making it clear, a statement like this would make it more complicated and hard to perceive. At time it might be better to break down a condition based on context to make it more understandable.
		if(isValidFreightPayment(a,b,c) &&  (c || d)){
		}
		 
	}
	
	public static boolean isValidFreightPayment(boolean a, boolean b, boolean c){
	    return a = true && (b = true || (c = true || a = true));
	}
}
