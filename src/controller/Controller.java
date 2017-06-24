package controller;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

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
	
	public Controller(){
		
		grid = new NodeGrid();
		
		Player user = new User();
		placeShipsRandomly(user);
		
		
		gui = new BattleshipGUI();
		gridPane = gui.getGridPane();
		
		updateGridView(user);
	
	};
	
	public boolean checkNodeAvailability(Node n){
		if(n.isOccupied())
			return false;
		
		return true;
	}
	
	public void placeShipsRandomly(Player user){
		boolean successfulPlacement = false;
		
		for(Ship s: user.getShips()){
			while(!successfulPlacement){
				successfulPlacement = placeShip(s);
			}
			successfulPlacement = false;
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
			Node[] nodeNodes = s.getOccupiedNodes();
			
			for(int j = 0; j < nodeNodes.length; j++){
				x = nodeNodes[j].getX();
				y = nodeNodes[j].getY();
				
				buttons[x][y].setBackground(Color.cyan);
				buttons[x][y].setText(Character.toString(s.getSymbol()));
			}
		}
	}
	

}
