package com.evoke.cleancode.advanced.others;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakEqualsHashCode {

	public static void main(String args[]) {
		Map<Person, Integer> map = new HashMap<>();
	    for(int i=0; i<100; i++) {
	        map.put(new Person("jon"), 1);
	    }
	    
	    System.out.println("Map Size: "+ map.size());
	}
}
