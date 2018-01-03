package data;

import java.util.ArrayList;

import models.Node;
import models.Player;
import models.User;


/**
 * This Class contains information for the Nodes and Players
 * @author Levi Thieme
 *
 */
public class GameData {
	private Node[][] nodes;
	private Player user;
	private Player AI;
	
	public GameData(){
		
		user = new User();
		AI = new models.AI();
		
		nodes = new Node[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				nodes[row][column] = new Node();
				nodes[row][column].setOccupied(false);
			}
		}
		
		setAdjacentNodes();
	}
	
	/**
	 *
	 * @return A reference to user
	 */
	public Player getUser() {
		return user;
	}

	/**
	 * 
	 * @return A reference to AI
	 */
	public Player getAI() {
		return AI;
	}

	/**
	 * Sets each nodes' adjacent nodes
	 */
	public void setAdjacentNodes(){
		int rowLess = 0, rowGreater = 0, colLess = 0, colGreater = 0;
		
		int arrayRows = nodes.length -1 ;
		int arrayColumns = nodes[0].length -1;
		
		//Setting adjacent nodes for each node
		for(int i = 0; i <= arrayRows; i++){
			for(int j = 0; j <= arrayColumns; j++){
				
				if(i > 0)
					rowLess = i - 1;
				else if(i == 0)
					rowLess = -1;
				
				if(i < arrayRows)
					rowGreater = i + 1;
				else if(i == arrayRows)
					rowGreater = -1;
				
				if(j > 0)
					colLess = j - 1;
				else if(j == 0)
					colLess = -1;
				
				if(j < arrayColumns)
					colGreater = j + 1;
				else if(j == arrayColumns)
					colGreater = -1;
				
				
				//Add neighbors in a clockwise direction starting at the top left diagonally adjacent node
				
				//If the node is not an edge node
				if(rowLess != -1 && rowGreater != -1 && colLess != -1 && colGreater != -1){
					//neighbors above
					nodes[i][j].addNeighbor(nodes[rowLess][colLess]);
					nodes[i][j].addNeighbor(nodes[rowLess][j]);
					nodes[i][j].addNeighbor(nodes[rowLess][colGreater]);
					
					//right neighbor
					nodes[i][j].addNeighbor(nodes[i][colGreater]);
					
					//neighbors below
					nodes[i][j].addNeighbor(nodes[rowGreater][colGreater]);
					nodes[i][j].addNeighbor(nodes[rowGreater][j]);
					nodes[i][j].addNeighbor(nodes[rowGreater][colLess]);
					
					//left neighbor
					nodes[i][j].addNeighbor(nodes[i][colLess]);
				} //If top row node
				else if(rowLess == -1 && rowGreater != -1 && colLess != -1 && colGreater != -1){
					nodes[i][j].addNeighbor(nodes[i][colLess]);
					nodes[i][j].addNeighbor(nodes[rowGreater][colLess]);
					nodes[i][j].addNeighbor(nodes[rowGreater][j]);
					nodes[i][j].addNeighbor(nodes[rowGreater][colGreater]);
					nodes[i][j].addNeighbor(nodes[i][colGreater]);
					
				} //If bottom row node
				else if(rowLess != -1 && rowGreater == -1 && colLess != -1 && colGreater != -1){
					nodes[i][j].addNeighbor(nodes[i][colLess]);
					nodes[i][j].addNeighbor(nodes[rowLess][colLess]);
					nodes[i][j].addNeighbor(nodes[rowLess][j]);
					nodes[i][j].addNeighbor(nodes[rowLess][colGreater]);
					nodes[i][j].addNeighbor(nodes[i][colGreater]);
				} //If left column node
				else if(rowLess != -1 && rowGreater != -1 && colLess == -1 && colGreater != -1){
					nodes[i][j].addNeighbor(nodes[rowLess][j]);
					nodes[i][j].addNeighbor(nodes[rowLess][colGreater]);
					nodes[i][j].addNeighbor(nodes[i][colGreater]);
					nodes[i][j].addNeighbor(nodes[rowGreater][colGreater]);
					nodes[i][j].addNeighbor(nodes[rowGreater][j]);
				} //If right column node
				else if(rowLess != -1 && rowGreater != -1 && colLess != -1 && colGreater == -1){
					nodes[i][j].addNeighbor(nodes[rowLess][j]);
					nodes[i][j].addNeighbor(nodes[rowLess][colLess]);
					nodes[i][j].addNeighbor(nodes[i][colLess]);
					nodes[i][j].addNeighbor(nodes[rowGreater][colLess]);
					nodes[i][j].addNeighbor(nodes[rowGreater][j]);
				}
			}
		}
		
		//Setting corner nodes neighbors
		
		//top left corner
		nodes[0][0].addNeighbor(nodes[0][1]);
		nodes[0][0].addNeighbor(nodes[1][1]);
		nodes[0][0].addNeighbor(nodes[1][0]);
		
		//top right corner
		nodes[0][9].addNeighbor(nodes[0][8]);
		nodes[0][9].addNeighbor(nodes[1][8]);
		nodes[0][9].addNeighbor(nodes[1][9]);
		
		//bottom left corner
		nodes[9][0].addNeighbor(nodes[8][0]);
		nodes[9][0].addNeighbor(nodes[8][1]);
		nodes[9][0].addNeighbor(nodes[9][1]);
		
		//bottom right corner
		nodes[9][9].addNeighbor(nodes[9][8]);
		nodes[9][9].addNeighbor(nodes[8][8]);
		nodes[9][9].addNeighbor(nodes[8][9]);

		
		
	}
	
	/**
	 * 
	 * @return A reference to nodes
	 */
	public Node[][] getNodes(){
		return nodes;
	}
	
	
	/**
	 * 
	 * @param n The node to be set as occupied
	 */
	public void setNodeOccupied(Node n){
		nodes[n.getRow()][n.getColumn()].setOccupied(true);
	}
	
	/**
	 * 
	 * @param n The node to be checked for occupation status
	 * @return True if occupied, otherwise False
	 */
	public boolean isNodeOccupied(Node n){
		if(nodes[n.getRow()][n.getColumn()].isOccupied())
			return true;
		
		return false;
	}
	
}
