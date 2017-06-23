package controller;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

import views.BattleshipGUI;
import views.NodeGridPanel;

import data.NodeGrid;

import models.Player;
import models.Point;
import models.Ship;
import models.User;

public class Controller {
	NodeGrid grid;
	BattleshipGUI gui;
	NodeGridPanel gridPane;
	
	public Controller(){
		
		grid = new NodeGrid();
		
		Player user = new User();
		
		for(Ship s: user.getShips()){
			placeShip(s);
		}
		
		gui = new BattleshipGUI();
		gridPane = gui.getGridPane();
		
		updateGridView(user);
	
	};
	
	
	public void placeShip(Ship ship){
		
		Point[] shipPoints = new Point[ship.getLength()];
		
		Random random = new Random();
		
		
		int row = random.nextInt(10 - ship.getLength());
		if(row < ship.getLength())
			row = ship.getLength();
		
		int column = random.nextInt(10 - ship.getLength());
		if(column < ship.getLength())
			column = ship.getLength();
		
		
		
		
		shipPoints[0] = new Point(row, column);
		if(grid.isNodeOccupied(shipPoints[0]))
			placeShip(ship);
		
		
		int orientation = random.nextInt(4);
		
		//Upwards orientation from start node
		if(orientation == 0){
			for(int i = 1; i < ship.getLength(); i++){
				shipPoints[i] = new Point(row, column - i);
				
				if(grid.isNodeOccupied(shipPoints[i]))
					placeShip(ship);
			}
		}
		
		//Downwards orientation from start node
		if(orientation == 1){
			for(int i = 1; i < ship.getLength(); i++){
				shipPoints[i] = new Point(row, column + i);
			
			if(grid.isNodeOccupied(shipPoints[i]))
				placeShip(ship);
		}
		}
		
		//Leftwards orientation from start node
		if(orientation == 2){
			for(int i = 1; i < ship.getLength(); i++){
				shipPoints[i] = new Point(row - i, column);
				
				if(grid.isNodeOccupied(shipPoints[i]))
					placeShip(ship);
			}
		}
		
		//Rightwards orientation from start node
		if(orientation == 3){
			for(int i = 1; i < ship.getLength(); i++){
				shipPoints[i] = new Point(row + i, column);
				
				if(grid.isNodeOccupied(shipPoints[i]))
					placeShip(ship);
			}
		}
		
		for(int i = 0; i < shipPoints.length; i++){
			grid.setNodeOccupied(shipPoints[i]);
		}
		
		ship.setOccupiedNodes(shipPoints);
		for(Point p: shipPoints)
			System.out.println(p.toString());
		
	}
	
	public void updateGridView(Player player){
		
		JButton[][] buttons = gridPane.getButtonNodes();
		
		Ship[] ships = player.getShips();
		
		int x;
		int y;
		
		for(int i = 0; i < ships.length; i++){
			Ship s = ships[i];
			Point[] nodePoints = s.getOccupiedNodes();
			
			for(int j = 0; j < nodePoints.length; j++){
				x = nodePoints[j].getX();
				y = nodePoints[j].getY();
				
				buttons[x][y].setBackground(Color.cyan);
			}
		}
	}
	

}
