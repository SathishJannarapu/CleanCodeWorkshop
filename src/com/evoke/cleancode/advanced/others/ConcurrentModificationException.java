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
		
		concurrentModificationException(hats);

		//Collect objects and remove them in another loop
		usingSeprateListToRemove(hats);

		hats.add(new Ushanka());
		//Use Iterator.remove method
		usingIterator(hats);

		hats.add(new Ushanka());
		//Use ListIterator’s methods
		usingListIterator(hats);

		hats.add(new Ushanka());
		//With ListIterator, the remove and add method calls can be replaced with a single call to set:
		usingListIteratorSingleOperation(hats);

		hats.add(new Ushanka());
		//Use stream methods introduced in Java 8 With Java 8, programmers have the ability to transform a collection into a stream and filter that stream according to some criteria.
		//Here is an example of how stream api could help us filter hats and avoid “ConcurrentModificationException
		hats = usingStream(hats);

		

	}

	private static void usingListIteratorSingleOperation(List<IHat> hats) {
		IHat visor = new Visor();
		ListIterator<IHat> hatListIterator2 = hats.listIterator();
		while (hatListIterator2.hasNext()) {
		    IHat hat = hatListIterator2.next();
		    if (hat.hasEarFlaps()) {
		    	hatListIterator2.set(visor); // set instead of remove and add
		    }
		}
		System.out.println("usingListIteratorSingleOperation: "+hats);
	}

	private static List<IHat> usingStream(List<IHat> hats) {
		hats = hats.stream().filter((hat -> !hat.hasEarFlaps()))
		        .collect(Collectors.toCollection(ArrayList::new));
		System.out.println("usingStream: "+hats);
		return hats;
	}

	private static void usingListIterator(List<IHat> hats) {
		IHat fez = new Fez();
		ListIterator<IHat> hatListIterator = hats.listIterator();
		while (hatListIterator.hasNext()) {
		    IHat hat = hatListIterator.next();
		    if (hat.hasEarFlaps()) {
		    	hatListIterator.remove();
		    	hatListIterator.add(fez);
		    }
		}
		System.out.println("usingListIterator: "+hats);
	}

	private static void usingIterator(List<IHat> hats) {
		Iterator<IHat> hatIterator = hats.iterator();
		while (hatIterator.hasNext()) {
		    IHat hat = hatIterator.next();
		    if (hat.hasEarFlaps()) {
		        hatIterator.remove();
		    }
		}
		System.out.println("usingIterator: "+hats);
	}

	private static void usingSeprateListToRemove(List<IHat> hats) {
		List<IHat> hatsToRemove = new LinkedList<>();
		for (IHat hat : hats) {
		    if (hat.hasEarFlaps()) {
		        hatsToRemove.add(hat);
		    }
		}
		for (IHat hat : hatsToRemove) {
		    hats.remove(hat);
		}
		
		System.out.println("usingSeprateListToRemove: "+hats);
	}

	private static void concurrentModificationException(List<IHat> hats) {
		for (IHat hat : hats) {
		    if (hat.hasEarFlaps()) {
		        hats.remove(hat);
		    }
		}
	}
}
