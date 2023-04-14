package com.evoke.cleancode.advanced.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ConcurrentModificationException {

	public static void main(String args[]) {
		
		List<IHat> hats = new ArrayList<>();
		hats.add(new Ushanka()); // that one has ear flaps
		hats.add(new Fedora());
		hats.add(new Sombrero());
		for (IHat hat : hats) {
		    if (hat.hasEarFlaps()) {
		        hats.remove(hat);
		    }
		}

		//Collect objects and remove them in another loop
		List<IHat> hatsToRemove = new LinkedList<>();
		for (IHat hat : hats) {
		    if (hat.hasEarFlaps()) {
		        hatsToRemove.add(hat);
		    }
		}
		for (IHat hat : hatsToRemove) {
		    hats.remove(hat);
		}

		
		//Use Iterator.remove method
		Iterator<IHat> hatIterator = hats.iterator();
		while (hatIterator.hasNext()) {
		    IHat hat = hatIterator.next();
		    if (hat.hasEarFlaps()) {
		        hatIterator.remove();
		    }
		}

		//Use ListIterator’s methods
		IHat sombrero = new Sombrero();
		ListIterator<IHat> hatListIterator = hats.listIterator();
		while (hatListIterator.hasNext()) {
		    IHat hat = hatListIterator.next();
		    if (hat.hasEarFlaps()) {
		    	hatListIterator.remove();
		    	hatListIterator.add(sombrero);
		    }
		}

		//With ListIterator, the remove and add method calls can be replaced with a single call to set:
	
		IHat sombrero2 = new Sombrero();
		ListIterator<IHat> hatListIterator2 = hats.listIterator();
		while (hatListIterator2.hasNext()) {
		    IHat hat = hatListIterator2.next();
		    if (hat.hasEarFlaps()) {
		    	hatListIterator2.set(sombrero2); // set instead of remove and add
		    }
		}

		//Use stream methods introduced in Java 8 With Java 8, programmers have the ability to transform a collection into a stream and filter that stream according to some criteria.
		//Here is an example of how stream api could help us filter hats and avoid “ConcurrentModificationException
		
		hats = hats.stream().filter((hat -> !hat.hasEarFlaps()))
		        .collect(Collectors.toCollection(ArrayList::new));

		//Use specialized collections
		List<IHat> filteredHats = hats.stream().peek(hat -> {
		    if (hat.hasEarFlaps()) {
		        hats.remove(hat);
		    }
		}).collect(Collectors.toCollection(ArrayList::new));

	}
}
