package com.evoke.cleancode.advanced.others;

import java.util.List;
import java.util.Optional;

public class NullReference {

	public  void main(String args[]) {
		List<String> accountIds = getAccountIds();
		for (String accountId : accountIds) {
		    //processAccount(accountId);
		}

		//If getAccountIds() returns null when a person has no account, then NullPointerException will be raised. 
		//To fix this, a null-check will be needed. However, if instead of a null it returns an empty list, then NullPointerException is no longer a problem.
		// Moreover, the code is cleaner since we don’t need to null-check the variable accountIds.
		// To deal with other cases when one wants to avoid nulls, different strategies may be used. 
		//One of these strategies is to use Optional type that can either be an empty object or a wrap of some value:

		String nullableString = null;
		Optional<String> optionalString = Optional.ofNullable(nullableString );
		if(optionalString.isPresent()) {
		    System.out.println(optionalString.get());
		}
		
		//In fact, Java 8 provides a more concise solution:
			Optional<String> optionalString2 = Optional.ofNullable(nullableString);
			optionalString2.ifPresent(System.out::println);


	}
	private List<String> getAccountIds(){
		return null;
	}
}
