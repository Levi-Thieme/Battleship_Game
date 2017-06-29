package views;


import javax.swing.JPanel;

import models.Node;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class NodeGridPanel extends JPanel implements ActionListener{
	Node[][] buttonNodes;
	ArrayList<Node> selectedNodes = new ArrayList<>();
	private boolean placingShips = false;
	private boolean shipPlaced = false;
	private int shipLength;
	
	public NodeGridPanel(){
		
		setPreferredSize(new Dimension(500, 400));
		setLayout(new GridLayout(10, 10, 5, 5));
		
		buttonNodes = new Node[10][10];
		
		
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				
				Node node = new Node(row, column);
				node.addActionListener(this);
				
				buttonNodes[row][column] = node;
				this.add(buttonNodes[row][column]);
			}
		}		
	}
	
	public void solicitUserShipPlacement(String name, int shipLength){
		this.shipLength = shipLength;
		
		JOptionPane.showMessageDialog(null, "Place your " + name +
				"\nIt requires " + shipLength + " spaces.");
		return;
	}

	public Node[][] getButtonNodes() {
		return buttonNodes;
	}
	
	public ArrayList<Node> getSelectedNodes(){
		
		ArrayList<Node> selectedNodesCopy = new ArrayList<>();
		for(int i = 0; i < selectedNodes.size(); i++)
			selectedNodesCopy.add(selectedNodes.get(i));
		
		selectedNodes.clear();
		
		return selectedNodesCopy;
	}
	
	public void setPlacingShips(boolean b){
		placingShips = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(placingShips){
			
			Node selectedButton = (Node) e.getSource();
			
			buttonNodes[selectedButton.getX()][selectedButton.getY()].setBackground(Color.DARK_GRAY);
			buttonNodes[selectedButton.getX()][selectedButton.getY()].add(selectedButton);
			/*
			if(selectedNodes.size() < shipLength){
				
				for(int i = 0; i < selectedNodes.size(); i++){
					
					if(selectedNodes.size() > 0){
						if(selectedNodes.get(i).isAdjacent(selectedButton)){
							selectedButton.setBackground(Color.DARK_GRAY);
							selectedNodes.add(selectedButton);
						}
					}
					else{
						selectedButton.setBackground(Color.DARK_GRAY);
						selectedNodes.add(selectedButton);
					}
				}
			}	*/
		}
	}
	
	public void clearSelectedNodes(){
		selectedNodes.clear();
	}


}
