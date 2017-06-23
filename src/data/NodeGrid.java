package data;

import models.Node;
import models.Point;

public class NodeGrid {
	private Node[][] nodes;
	
	public NodeGrid(){
		
		nodes = new Node[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				nodes[row][column] = new Node();
				nodes[row][column].setPoint(new Point(row, column));
				nodes[row][column].setOccupied(false);
			}
		}
	}
	
	public void setNodeOccupied(Point p){
		nodes[p.getX()][p.getY()].setOccupied(true);
	}
	
	public boolean isNodeOccupied(Point p){
		if(nodes[p.getX()][p.getY()].isOccupied())
			return true;
		
		return false;
	}

}
