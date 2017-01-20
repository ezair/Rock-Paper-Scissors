package myClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

	//enter an int and it checks the exceptions
	public static int handleNextInt(Scanner ui) {
		  boolean error = false;
		   do {
		      try {
					error = false;
					int value = ui.nextInt();
	           		return value;
				}//try
				catch(InputMismatchException ex) {
					ui.next(); //clear buffer
					error = true;
					System.out.print("\nError, That is not a number: ");
				}//catch
				catch(ArrayIndexOutOfBoundsException ex) {	
					ui.next(); //clear buffer
					error = true;
					System.out.println("\nChoice a valid option");
				}//catach
			}while(error == true);
			return  0;
		}//end




}//class