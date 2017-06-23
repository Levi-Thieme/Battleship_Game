package models;

import java.awt.Color;

public class Node {
	
	private Point point;
	private boolean occupied;
	private Color color;
	
	
	public Node(){
		
	}
	
	public Node(Point p, Color c){
		point = p;
		color = c;
	}
	
	
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
