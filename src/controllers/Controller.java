package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import views.BattleshipGUI;
import views.NodeGridPanel;

import data.NodeGrid;
import models.Node;
import models.Player;
import models.Ship;
import models.User;

public class Controller implements Observer{
	private NodeGrid grid;
	private BattleshipGUI gui;
	private NodeGridPanel userGridPane;
	private NodeGridPanel AIGridPane;
	private Player user;
	private Player AI;
	private Ship shipCurrentlyBeingPlaced;

	
	public Controller(BattleshipGUI gui){
		
		grid = new NodeGrid();
		
		user = new User();
		AI = new models.AI();
		
		this.gui = gui;
		
		
		userGridPane = gui.getUserGridPane();
		userGridPane.setPlacingShips(true);
		
		
		AIGridPane = gui.getAIGridPane();
		AIGridPane.setPlacingShips(false);
		
		placeShipsRandomly(AI);
		updateGridView(AI);
		
		
		gui.setVisible(true);
		
	};
	
	public void solicitShipPlacement(Ship ship){
		userGridPane.setPlacingShips(true);
				
		
		JOptionPane.showMessageDialog(null, "Place your " + ship.getName() + ". It requires " 
				+ ship.getLength() + " spaces.");
		
		shipCurrentlyBeingPlaced = ship;
		
	}
		
	
	

	
	public void placeShipsRandomly(Player user){
		boolean successfulPlacement;
	
		
		Ship[] ships = AI.getShips();
		
		for(int i = 0; i < ships.length; i++){
			do{
				successfulPlacement = randomlyPlaceShip(ships[i]);
			}while(successfulPlacement == false);
		}
		
	}
	
	
	public boolean randomlyPlaceShip(Ship ship){
		
		Node[] shipNodes = new Node[ship.getLength()];
		
		Random random = new Random();
		
		
		int row = random.nextInt(11 - ship.getLength());
		if(row < ship.getLength())
			row = ship.getLength();
		
		int column = random.nextInt(11 - ship.getLength());
		if(column < ship.getLength())
			column = ship.getLength();
		
		
		
		
		shipNodes[0] = new Node(row, column);
		
		if(grid.isNodeOccupied(shipNodes[0]))
			return false;
		
		
		int orientation = random.nextInt(4);
		
		//Upwards orientation from start node
		if(orientation == 0){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row, column - i);
				
				if(grid.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		//Downwards orientation from start node
		if(orientation == 1){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row, column + i);
			
				if(grid.isNodeOccupied(shipNodes[i]))
					return false;
			}	
		}
		
		//Leftwards orientation from start node
		if(orientation == 2){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row - i, column);
				
				if(grid.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		//Rightwards orientation from start node
		if(orientation == 3){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row + i, column);
				
				if(grid.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		for(int i = 0; i < shipNodes.length; i++){
			grid.setNodeOccupied(shipNodes[i]);
		}
		
		ship.setOccupiedNodes(shipNodes);
		
		return true;
	}
	
	public void updateGridView(Player player){
		
		JButton[][] buttons = AIGridPane.getNodes();
		
		Ship[] ships = player.getShips();
		
		int x;
		int y;
		
		for(int i = 0; i < ships.length; i++){
			Ship s = ships[i];
			Node[] shipNodes = s.getOccupiedNodes();
			
			for(int j = 0; j < shipNodes.length; j++){
				x = shipNodes[j].getRow();
				y = shipNodes[j].getColumn();
				
				buttons[x][y].setBackground(Color.cyan);
				buttons[x][y].setText(Character.toString(s.getSymbol()));
			}
		}
	}
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
