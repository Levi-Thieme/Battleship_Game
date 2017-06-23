package models;

import java.awt.Color;

public abstract class Player {
	private String name;
	private Color color;
	private Ship[] ships;
	
	
	public Player(){
		ships = new Ship[5];
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Ship[] getShips() {
		return ships;
	}
	public void setShips(Ship[] ships) {
		this.ships = ships;
	}
	

}
