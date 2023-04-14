package com.evoke.cleancode.advanced.others;

import java.util.HashSet;
import java.util.Set;

public class BreakingContracts {

	public static void main(String[] args) {
	    Set<Boat> boats = new HashSet<Boat>();
	    boats.add(new Boat("Enterprise"));

	    System.out.printf("We have a boat named 'Enterprise' : %b\n", boats.contains(new Boat("Enterprise")));
	    
	    // As you can see, class Boat has overridden equals and hashCode methods. However, it has broken the contract, 
	    //because hashCode returns random values for the same object every time it’s called. 
	    //The following code will most likely not find a boat named “Enterprise” in the hashset, despite the fact that we added that kind of boat earlier:
	}

}
