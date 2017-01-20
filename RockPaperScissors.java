//Author: Eric Zair
//Program: RockPaperScissors.java
//Description: This is the client program for RockPaperScissors.java

import java.util.Scanner;
import myClasses.Exceptions;


public class RockPaperScissors {


	public static void main(String[] args) {		
		//Variables
		boolean error = false;
		int numberOfGames = 0;
		int enteredOption = 0;
		Scanner scan = new Scanner(System.in);
		//Create 2 player objects
		Player[] players = new Player[2];
		//String to see if the user wants to play again
		String playAgain = "";
		//-----------------------------------


		//display rules of game
		printRules();


		//have users enter their names and set them
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player();
			System.out.print("Enter the name of Player" + (i+1) + ": ");
			String name = scan.nextLine();
			players[i].setName(name);
			System.out.println("\n");
		}//for


		do {
			
			//ask user to enter the number of games
			//do to make sure number entered is odd
			do {
				numberOfGames = Exceptions.handleNextInt(scan, "Enter the number of Games(must be ODD): "
				, "Error that is not a valid input\n");
			}while(isOdd(numberOfGames) == false);


			//loop and play game. game probablility
			//check who wins
			for(int i = 0; i < (numberOfGames*players.length); i++) {
				String errorMessage = "Error: enter a valid option";

				//if even it is player1's turn else player two's turn
				System.out.println(players[i%2].getName() + "'s turn.");


				//do while to make sure the answer entered is valid
				do {
					error = false;
					enteredOption = Exceptions.handleNextInt(scan, "1)Rock\n2)Paper\n3)Scissors\nEnter an option: ", errorMessage);

					//make sure answer does not exceed bounds.
					if(enteredOption > 3 || enteredOption < 1) {
						System.out.println(errorMessage);
						error = true;
					}

				}while(error == true);


				//set the player's anwer
				players[i%2].setUserOption(enteredOption);


				//make sure that i  is greater than 1 so that the loop does not execute at first run
				//make sure i is odd so that the scores can be compared.
				if(i%2 == 1 && i > 0) {
					//check if it is a tie
					if(players[0].getUserOption() == players[1].getUserOption())
						System.out.println("It's a tie.\n");
							
					//check if player 1 wins
					else if( (players[0].getUserOption() == 0 && players[1].getUserOption() == 2)
					|| (players[0].getUserOption() == 1 && players[1].getUserOption() == 0)
					|| (players[0].getUserOption() == 2 && players[1].getUserOption() == 1) ) {

						System.out.println(players[0].getName() + " wins this round.\n");
						players[0].setNumberOfWins();
						players[1].setNumberOfLoses();
					}//else if

					else {
						System.out.println(players[1].getName() + " wins that round.\n");
						players[1].setNumberOfWins();
						players[0].setNumberOfLoses();
					}//else
				}//if
				
			}//for

			//print the results of the game
			printResults(players);	

			//ask user if wants to play again
			//if they don't give a correct and answer it asks again.
			do {
				System.out.print("Do you wanna play again(Y/N)?");
				playAgain = scan.next();
				System.out.println();
			}while( !(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("n")) );


		}while(playAgain.equalsIgnoreCase("y"));

		//if the user does not want to play Again.
		exit("Good Bye.");

	}//main


	//methods-----------------------------------------------------------
	//method prints rules for game
	public static void printRules() {
		System.out.println("This Program is a Rock paper scissors game."
			+ " The player that wins the most games is the winner.\n");
	}//end

	//method checks to see if number is odd
	public static boolean isOdd(int number) {
		if(number % 2 == 0)
			return false;
		else
			return true;
	}//end


	public static void printResults(Player[] players) {
		int winDifference = Math.abs(players[0].getNumberOfWins() - players[1].getNumberOfWins());
		String line = "---------------------------------";

		System.out.println(line + "\nFinal Results:\n");
		
		//prints results
		for(int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName() + ":");
			System.out.println("Wins: " + players[i].getNumberOfWins());
			System.out.println("Loses: " + players[i].getNumberOfLoses() + "\n");	
		}
		if(players[0].getNumberOfWins() > players[1].getNumberOfWins()) 
			System.out.println(players[0].getName() + " won " + winDifference + " more game(s)");
		else if (players[1].getNumberOfWins() > players[0].getNumberOfWins())
			System.out.println(players[1].getName() + " won " + winDifference + " more game(s)");
		else 
			System.out.println("Both players won the same amount of games");
		System.out.println(line);
	}//end

	public static void exit(String message) {
		System.out.println(message);
		System.exit(0);
	}

}//class