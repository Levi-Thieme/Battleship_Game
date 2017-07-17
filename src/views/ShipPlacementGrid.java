package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.Node;

public class ShipPlacementGrid extends JPanel implements MouseListener {
	Node[][] nodes;
	ArrayList<Node> selectedNodes;
	private int shipLength;
	private int orientation = 0; // 0 for vertical, 1 for horizontal
	private ArrayList<Node> highlightedNodes = new ArrayList<>();
	private boolean shipBeingPlaced = false;
	public final static int VERTICAL_ORIENTATION = 0;
	public final static int HORIZONTAL_ORIENTATION = 1;
	
	public ShipPlacementGrid(){
		setPreferredSize(new Dimension(500, 400));
		setLayout(new GridLayout(10, 10, 5, 5));
		
		selectedNodes = new ArrayList<Node>();
		
		nodes = new Node[10][10];
		
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				
				Node node = new Node(row, column);
				//node.addActionListener(this);
				node.addMouseListener(this);
				
				nodes[row][column] = node;
				this.add(nodes[row][column]);
			}
		}	
		
	}
	
	
	/**
	 *
	 * @return nodes
	 */
	public Node[][] getNodes() {
		return nodes;
	}
	
	/**
	 * Returns a copy of the selectedNodes and clear selectedNodes
	 * @return copy of selectedNodes
	 */
	public ArrayList<Node> getSelectedNodes(){
		
		ArrayList<Node> selectedNodesCopy = new ArrayList<>();
		for(int i = 0; i < selectedNodes.size(); i++)
			selectedNodesCopy.add(selectedNodes.get(i));
		
		return selectedNodesCopy;
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
	 * Resets the highlighted nodes' background and border
	 * to the default values and clears the highlightedNodes
	 * array list.
	 */
	public void resetHighlightedNodes(){
		for(Node n : highlightedNodes){
			if(!n.isOccupied()){
				n.setBackground(new Node().getBackground());
				n.setBorder(new Node().getBorder());
			}
		}
		
		highlightedNodes.clear();	
	}
	
			
	@Override
	public void mouseClicked(MouseEvent e) {
		for(Node n : highlightedNodes){
			if(n.isOccupied()){
				JOptionPane.showMessageDialog(null, "You cannot overlap ships.");
				resetHighlightedNodes();
				return;
			}
		}
		
		selectedNodes.addAll(highlightedNodes);
		highlightedNodes.clear();
		
		for(Node n : selectedNodes){
			n.setOccupied(true);
		}
		shipBeingPlaced = false;
		shipLength = 0;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(shipBeingPlaced){
			Node mousedOverNode	= (Node) e.getComponent();
			highlightedNodes.clear();
			
			highlightedNodes.add(mousedOverNode);
			
		
			int row = mousedOverNode.getRow();
			int column = mousedOverNode.getColumn();
			
			int countAbove = 0, countBelow = 0, countLeft = 0, countRight = 0;
			
			
			
	
			
			if(orientation == VERTICAL_ORIENTATION){
				
				if(shipLength == 5){
					countAbove = 2;
					countBelow = 2;
				}
				else if(shipLength == 4){
					countAbove = 2;
					countBelow = 1;
				}
				else if(shipLength == 3){
					countAbove = 1;
					countBelow = 1;
				}
				else if (shipLength == 2){
					countAbove = 1;
					countBelow = 0;
				}
				
				
				while(row - countAbove < 0){
					--countAbove;
					++countBelow;
				}
				
				while(row + countBelow > 9){
					--countBelow;
					++countAbove;
				}
				
				while(countAbove > 0){
					highlightedNodes.add(nodes[row - countAbove][column]);
					--countAbove;
				}
				
				while(countBelow > 0){
					highlightedNodes.add(nodes[row + countBelow][column]);
					--countBelow;
				}
				
							
			}
			else if(orientation == HORIZONTAL_ORIENTATION){
				
				if(shipLength == 5){
					countLeft = 2;
					countRight = 2;
				}
				else if(shipLength == 4){
					countLeft = 2;
					countRight = 1;
				}
				else if(shipLength == 3){
					countLeft = 1;
					countRight = 1;
				}
				else if (shipLength == 2){
					countLeft = 1;
					countRight = 0;
				}
				
				
				while(column - countLeft < 0){
					--countLeft;
					++countRight;
				}
				
				while(column + countRight > 9){
					--countRight;
					++countLeft;
				}
				
				while(countLeft > 0){
					highlightedNodes.add(nodes[row][column - countLeft]);
					--countLeft;
				}
				
				while(countRight > 0){
					highlightedNodes.add(nodes[row][column + countRight]);
					--countRight;
				}
			}
			
			
			
			for(Node n : highlightedNodes){
				n.setBackground(Color.GREEN);
				n.setBorder(new LineBorder(Color.black, 3));
			}
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
		for(Node n : highlightedNodes){
			if(!n.isOccupied()){
				n.setBackground(new Node().getBackground());
				n.setBorder(new Node().getBorder());
			}
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
	
	public void setShipLength(int length){
		shipLength = length;
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
	}
	
	public void setNodes(Node[][] nodes){
		this.nodes = nodes;
	}
	
	public void setShipBeingPlaced(boolean b){
		shipBeingPlaced = b;
	}
		
	




}
