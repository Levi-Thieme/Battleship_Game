package views;


import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.Node;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class NodeGridPanel extends JPanel implements ActionListener {
	Node[][] nodes;
	ArrayList<Node> selectedNodes;
	private boolean placingShips;
	private boolean shipPlaced;
	private int shipLength;
	
	public NodeGridPanel(){
		
		setPreferredSize(new Dimension(500, 400));
		setLayout(new GridLayout(10, 10, 5, 5));
		
		selectedNodes = new ArrayList<Node>();
		
		placingShips = false;
		shipPlaced = false;
		nodes = new Node[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				
				Node node = new Node(row, column);
				node.addActionListener(this);
				
				
				nodes[row][column] = node;
				this.add(nodes[row][column]);
			}
		}	
		
		setAdjacentNodes();
	}
	

	public Node[][] getNodes() {
		return nodes;
	}
	
	
	public ArrayList<Node> getSelectedNodes(){
		
		ArrayList<Node> selectedNodesCopy = new ArrayList<>();
		for(int i = 0; i < selectedNodes.size(); i++)
			selectedNodesCopy.add(selectedNodes.get(i));
		
		return selectedNodesCopy;
	}
	
	public void setPlacingShips(boolean b){
		placingShips = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Node selectedButton = (Node) e.getSource();
		
		if(placingShips){
			for(Node node: selectedNodes){ //verify the selected node has not already been added
				if(selectedButton == node)
					return;
			}
			
			selectedButton.setBackground(Color.DARK_GRAY);
			selectedNodes.add(selectedButton);
			
		}	
	}
		
	/**
	 * Empties the selectedNodes arrayList
	 */
	public void emptySelectedNodes(){
		selectedNodes.clear();
	}
	
	/**
	 * Resets the selected Nodes and clears the SelectedNodes arrayList
	 */
	public void resetSelectedNodes(){
		for(Node selectedNode: selectedNodes){
			selectedNode.setBackground(new Node().getBackground());
		}
		selectedNodes.clear();
	}
	
	
	
	
	/**
	 * This mouse listener highlights nodes vertically or horizontally for ship placement.
	 */
	public class SelectedNodesListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Node mousedOverNode	= (Node) e.getComponent();
			
			for(Node n : mousedOverNode.getAdjacentNodes()){
				n.setBackground(Color.GREEN);
				n.setBorder(new LineBorder(Color.black, 3));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Node mousedOverNode	= (Node) e.getComponent();
			
			for(Node n : mousedOverNode.getAdjacentNodes()){
				n.setBackground(new Node().getBackground());
				n.setBorder(new Node().getBorder());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	
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
	
	

}
