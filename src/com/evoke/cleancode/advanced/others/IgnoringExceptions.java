package com.evoke.cleancode.advanced.others;

public class IgnoringExceptions {

	public static void main(String args[]) {

		// simple try catch
		try {
	        checkAge(15);
	    } catch (Exception ignored) { }
		
		// Using functional interface
//        ignoreExc(() -> checkAge(16));
//        ignoreExc(() -> checkAge(17));
//        ignoreExc(() -> checkAge(18));

        System.out.println("Ignoring the exception");
        System.out.println("Continue code as normal");
    }

    static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be greater than 18");
        }
    }

    static void ignoreExc(Runnable r) {
        try {
            r.run();
        } catch (Exception ignored) { }
    }

    @FunctionalInterface
    interface Runnable {
        void run() throws Exception;
    }

}
