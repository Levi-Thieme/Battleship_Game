package ships;


import models.Ship;


public class Battleship extends Ship{
	
	public Battleship(String team){
		super(team, "Battleship", 5);
		super.setSymbol('B');
	}

}
