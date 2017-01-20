//Author: Eric Zair
//Program: Player.java
//Description: This is the Player class for a Rock Paper Scissors game

public class Player {


	//Variables for Player
	private int numberOfWins;
	private int numberOfLoses;
	private int userOption;
	private String name;

	//Constructor
	public Player(int numberOfWins, int numberOfLoses, int userOption, String name) {
		this.numberOfWins = numberOfWins;
		this.numberOfLoses = numberOfLoses;
		this.userOption = userOption;
		this.name = name;
	}


	//Default constructor
	public Player() {
		this(0, 0, 0, "N/A");
	}


	//getter methods
	public int getNumberOfWins() { return numberOfWins; }

	public int getNumberOfLoses() { return numberOfLoses; }

	public int getUserOption() { return userOption; }

	public String getName() { return name; }


	//setter methods
	public void setNumberOfWins() {
		this.numberOfWins++;
	}

	public void setNumberOfLoses() {
		this.numberOfLoses++;
	}

	public void setUserOption(int _userOption) {
		this.userOption = _userOption;
	}

	public void setName(String _name) {
		this.name = _name;
	}

}//end class