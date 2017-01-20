//Author: Eric Zair
//Package: myClasses
//File Name: usefulMethods.java
//Description: This file contains a list of useful methods that
//			   can be imported using "import myClasses.usefulMethods"


public class usefulMethods {

	//this method checks if a number given is odd or even
	public static boolean isOdd(int number) {
		if(number %2 == 1)
			return true;
		else
			return false;
	}//end


	//this method checks to see if a double is odd or even
	public static boolean doubleIsOdd(double number) {
		if(number %2 == 1)
			return true;
		else
			return false;
	}//end


	//this method checks to see if a number is in a certain range
	public static boolean isInRange(int number, int start, int end) {
		if(number < start || number > end)
			return false;

		return true;
	}//end


	//this method exits a program and gives an exit message
	public static void exit(String message) {
		System.out.println(message);
		System.exit(0);
	} 


}//class