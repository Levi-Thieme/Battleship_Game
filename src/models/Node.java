package models;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Node extends JButton {
	
	private boolean occupied;
	private boolean hit;
	private Color color;
	private int X;
	private int Y;

	public Node(){
		
	}
	
	public Node(int x, int y){
		setPreferredSize(new Dimension(10, 10));
		X = x;
		Y = y;
	}
	

	
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
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
		this.setBackground(color);
	}
	
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public boolean isHit() {
		return hit;
	}

}
