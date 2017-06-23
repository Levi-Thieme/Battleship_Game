package models;

public abstract class Ship {
	private String team;
	private String name;
	private	Point[] occupiedNodes;
	private int length;
	
	
	
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
	public Point[] getOccupiedNodes() {
		return occupiedNodes;
	}
	public void setOccupiedNodes(Point[] occupiedNodes) {
		this.occupiedNodes = occupiedNodes;
	}
	public void setLength(int length){
		this.length = length;
	}
	public int getLength(){
		return length;
	}
	
	
}
