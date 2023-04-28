package com.evoke.cleancode.advanced.others;

import java.util.List;
import java.util.Optional;

public class NullReference {

public static void main(String args[]) {
		
		List<String> accountIds = getAccountIds();
		for (String accountId : accountIds) {
		    processAccount(accountId);
		}

		String nullableString = null;
		Optional<String> optionalString = Optional.ofNullable(nullableString );
		if(optionalString.isPresent()) {
		    System.out.println(optionalString.get());
		}


	}
	private static void processAccount(String accountId) {
		// TODO Auto-generated method stub
		
	}
	private static List<String> getAccountIds(){
		return null;
	}
}
