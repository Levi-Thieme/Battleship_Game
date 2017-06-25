package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import views.BattleshipGUI;
import views.NodeGridPanel;

import data.NodeGrid;
import models.Node;
import models.Player;
import models.Ship;
import models.User;

public class Controller {
	NodeGrid grid;
	BattleshipGUI gui;
	NodeGridPanel gridPane;
	
	public Controller(BattleshipGUI gui){
		
		grid = new NodeGrid();
		
		Player user = new User();
		placeShipsRandomly(user);
		
		
		this.gui = gui;
		
		gridPane = gui.getUserGridPane();
		
		updateGridView(user);

	};
	
	public void solicitUserShipPlacement(Ship s){
		JOptionPane.showMessageDialog(null, "Place your " + s.getName() +
				"\nIt requires " + s.getLength() + " spaces.");
		
		gridPane.setPlacingShips(true);
		ArrayList<Node> selectedNodes = gridPane.getSelectedNodes();
		gridPane.setPlacingShips(false);
	}
	
	public boolean checkNodeAvailability(Node n){
		if(n.isOccupied())
			return false;
		
		return true;
	}
	
	public void placeShipsRandomly(Player user){
		boolean successfulPlacement;
	
		
		Ship[] ships = user.getShips();
		
		for(int i = 0; i < ships.length; i++){
			do{
				successfulPlacement = placeShip(ships[i]);
			}while(successfulPlacement == false);
		}
		
	}
	
	
	public boolean placeShip(Ship ship){
		
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
		
		JButton[][] buttons = gridPane.getButtonNodes();
		
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
	

}
