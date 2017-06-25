package data;

import models.Node;

public class NodeGrid {
	private Node[][] nodes;
	
	public NodeGrid(){
		
		nodes = new Node[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				nodes[row][column] = new Node();
				nodes[row][column].setOccupied(false);
			}
		}
	}
	
	public Node[][] getNodes(){
		return nodes;
	}
	
	public void setNodeOccupied(Node n){
		nodes[n.getRow()][n.getColumn()].setOccupied(true);
	}
	
	public boolean isNodeOccupied(Node n){
		if(nodes[n.getRow()][n.getColumn()].isOccupied())
			return true;
		
		return false;
	}

}
