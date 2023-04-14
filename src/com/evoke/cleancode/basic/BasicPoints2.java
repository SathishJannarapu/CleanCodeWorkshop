package com.evoke.cleancode.basic;

public class BasicPoints2 {

	// 6.	Avoid using confusing magic numbers
	Document getDocument(int state){
		if(state == 1){ 
   			 return new ActiveDocument();
		 } else if (state == 2){ //2 = Cancel
    			return new CanceledDocument();
		}
		return null;
	}
	
	private static final int ACTIVE = 1;
	private static final int CANCEL = 2;
// or
	public enum State {
		//ACTIVE(1),
		//CANCEL(2);
//		private int value;
//		public int getValue() {
//			return value;
//		}
}


}
