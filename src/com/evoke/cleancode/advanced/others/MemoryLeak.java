package com.evoke.cleancode.advanced.others;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MemoryLeak {

	public static void main(String args[]) {
		final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		final Deque<BigDecimal> numbers = new LinkedBlockingDeque<>();
		final BigDecimal divisor = new BigDecimal(51);
		
		Runnable task1 = () -> {
			BigDecimal number = numbers.peekLast();
			if (number != null && number.remainder(divisor).byteValue() == 0) {
				System.out.println("Number: " + number);
				System.out.println("Deque size: " + numbers.size());
			}
		};
		
		Runnable task2 = () -> {
			numbers.add(new BigDecimal(System.currentTimeMillis()));
		};
		scheduledExecutorService.scheduleAtFixedRate(task1, 10, 10, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(task2, 10, 10, TimeUnit.MILLISECONDS);
		try {
			scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * This example creates two scheduled tasks. The first task takes the last
	 * number from a deque called “numbers” and prints the number and deque size in
	 * case the number is divisible by 51. The second task puts numbers into the
	 * deque. Both tasks are scheduled at a fixed rate, and run every 10 ms. If the
	 * code is executed, you’ll see that the size of the deque is permanently
	 * increasing. This will eventually cause the deque to be filled with objects
	 * consuming all available heap memory. To prevent this while preserving the
	 * semantics of this program, we can use a different method for taking numbers
	 * from the deque: “pollLast”. Contrary to the method “peekLast”, “pollLast”
	 * returns the element and removes it from the deque while “peekLast” only
	 * returns the last element.
	 */
}
