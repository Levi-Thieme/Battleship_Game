package models;

public abstract class Ship {
	private String team;
	private String name;
	private	Node[] occupiedNodes;
	private int length;
	private char symbol;
	
	

	public Ship(String team, String name, int length){
		this.team = team;
		this.name = name;
		this.length = length;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node[] getOccupiedNodes() {
		return occupiedNodes;
	}
	public void setOccupiedNodes(Node[] occupiedNodes) {
		this.occupiedNodes = occupiedNodes;
	}
	public void setLength(int length){
		this.length = length;
	}
	public int getLength(){
		return length;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	
}
