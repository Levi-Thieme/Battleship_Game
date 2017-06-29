package models;

import java.awt.Color;

import ships.Battleship;
import ships.Cruiser;
import ships.Destroyer;
import ships.Submarine;

public class AI extends Player{
	
	public AI(){
		super();
		setColor(Color.red);
		initializeFleet();
	}
	
	public void initializeFleet(){
		Ship[] ships = super.getShips();
		
		ships[0] = new Battleship("Test");
		ships[1] = new Cruiser("Test");
		ships[2] = new Destroyer("Test");
		ships[3] = new Destroyer("Test");
		ships[4] = new Submarine("Test");
	}

}
