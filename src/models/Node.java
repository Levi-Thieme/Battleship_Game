package models;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Node extends JButton {
	
	private boolean occupied;
	private boolean hit;
	private Color color;
	private int row;
	private int column;

	public Node(){
		setPreferredSize(new Dimension(10, 10));
	}
	
	
	public Node(int x, int y){
		setPreferredSize(new Dimension(10, 10));
		row = x;
		column = y;
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
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

}
