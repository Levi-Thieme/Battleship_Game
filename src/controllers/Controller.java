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

import data.GameData;
import models.Node;
import models.Player;
import models.Ship;
import models.User;


/**
 * The Controller class handles user input and ship placement
 * @author Levi Thieme
 *
 */
public class Controller {
	private GameData gameData;
	private BattleshipGUI gui;
	private NodeGridPanel userGridPane;
	private NodeGridPanel AIGridPane;
	private Player user;
	private Player AI;
	private Ship shipCurrentlyBeingPlaced;

	
	public Controller(GameData gameData){
		
		
		this.gameData = gameData;
		
		user = gameData.getUser();
		AI = gameData.getAI();
		
		gui = new BattleshipGUI();
		
		
		userGridPane = gui.getUserGridPane();
		
		AIGridPane = gui.getAIGridPane();
		AIGridPane.setPlacingShips(false);
		
		placeShipsRandomly();
		updateAIGridView();
		
		updateUserGridView();
		
		gui.setVisible(true);
	}
	

	/**
	 * Randomly places the AI's ships
	 */
	public void placeShipsRandomly(){
		boolean successfulPlacement;
	
		
		Ship[] ships = AI.getShips();
		
		for(int i = 0; i < ships.length; i++){
			do{
				successfulPlacement = randomlyPlaceShip(ships[i]);
			}while(successfulPlacement == false);
		}
		
	}
	
	/**
	 * Randomly places the ship 
	 * @param ship The ship to be placed
	 * @return True if ship was placed successfully, else return false
	 */
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
		
		if(gameData.isNodeOccupied(shipNodes[0]))
			return false;
		
		
		int orientation = random.nextInt(4);
		
		//Upwards orientation from start node
		if(orientation == 0){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row, column - i);
				
				if(gameData.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		//Downwards orientation from start node
		if(orientation == 1){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row, column + i);
			
				if(gameData.isNodeOccupied(shipNodes[i]))
					return false;
			}	
		}
		
		//Leftwards orientation from start node
		if(orientation == 2){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row - i, column);
				
				if(gameData.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		//Rightwards orientation from start node
		if(orientation == 3){
			for(int i = 1; i < ship.getLength(); i++){
				shipNodes[i] = new Node(row + i, column);
	
				if(gameData.isNodeOccupied(shipNodes[i]))
					return false;
			}
		}
		
		for(int i = 0; i < shipNodes.length; i++){
			gameData.setNodeOccupied(shipNodes[i]);
		}
		
		ship.setOccupiedNodes(shipNodes);
		
		return true;
	}
	
	
	public void updateUserGridView() {
		
		JButton[][] buttons = userGridPane.getNodes();
		
		Ship[] ships = user.getShips();
		
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
	
	
	public void updateAIGridView(){
		
		JButton[][] buttons = AIGridPane.getNodes();
		
		Ship[] ships = AI.getShips();
		
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
