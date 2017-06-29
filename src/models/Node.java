package models;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Node extends JButton {
	
	private boolean occupied;
	private boolean hit;
	private Color color;
	private int row;
	private int column;
	private ArrayList<Node> adjacentNodes;

	public Node(){
		setPreferredSize(new Dimension(10, 10));
		adjacentNodes = new ArrayList<>();
	}
	
	
	public Node(int x, int y){
		setPreferredSize(new Dimension(10, 10));
		row = x;
		column = y;
	}
	
	public boolean isAdjacent(Node n){
		for(int i = 0; i < adjacentNodes.size(); i++){
			if(n == adjacentNodes.get(i))
				return true;
		}
		return false;
	}
	
	
	public void addNeighbor(Node n){
		adjacentNodes.add(n);
	}
	
	public ArrayList<Node> getAdjacentNodes() {
		return adjacentNodes;
	}


	public void setAdjacentNodes(ArrayList<Node> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
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
