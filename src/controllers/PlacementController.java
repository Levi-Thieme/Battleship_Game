package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import data.GameData;
import models.Node;
import models.Player;
import models.Ship;
import views.ShipPlacementFrame;
import views.ShipPlacementGrid;

/**
 * This Class is the controller for ship placement.
 * @author Levi Thieme
 *
 */
public class PlacementController implements ActionListener {
	private GameData data;
	private ShipPlacementFrame placementFrame;
	private Player user;
	private ShipPlacementGrid placementGrid;
	private int placementCount;

	public PlacementController(){
		placementCount = 0;
		
		this.data = new GameData();
		user = data.getUser();
		
		placementFrame = new ShipPlacementFrame(this);
		placementFrame.setVisible(true);
		
		placementGrid = placementFrame.getPlacementGrid();
	}
	
	
	/**
	 * Sets the nodes where ships have been placed in
	 * the NodeGridData after the user has placed
	 * his/her ships
	 */
	public void setPlacedShips(){
		ArrayList<Node> shipPlacementNodes = placementFrame.getSelectedNodes();
		
		for(Node n: shipPlacementNodes)
			data.setNodeOccupied(n);
	}

	/**
	 * Handles ship and orientation selection
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Ship[] userShips = user.getShips();
		
		if(e.getActionCommand().equals("Place Carrier")){
			placementGrid.setShipBeingPlaced(userShips[0]);
			JButton carrierBtn = (JButton) e.getSource();
			carrierBtn.setEnabled(false);
			placementCount++;
		}
		else if(e.getActionCommand().equals("Place Cruiser")){
			placementGrid.setShipBeingPlaced(userShips[1]);
			JButton cruiserBtn = (JButton) e.getSource();
			cruiserBtn.setEnabled(false);
			placementCount++;
		}
		else if(e.getActionCommand().equals("Place Destroyer")){
			placementGrid.setShipBeingPlaced(userShips[2]);
			JButton destroyerBtn = (JButton) e.getSource();
			destroyerBtn.setEnabled(false);
			placementCount++;
		}
		else if(e.getActionCommand().equals("Place Submarine (1)")){
			placementGrid.setShipBeingPlaced(userShips[3]);
			JButton subBtn = (JButton) e.getSource();
			subBtn.setEnabled(false);
			placementCount++;
		}
		else if(e.getActionCommand().equals("Place Submarine (2)")){
			placementGrid.setShipBeingPlaced(userShips[4]);
			JButton subBtn = (JButton) e.getSource();
			subBtn.setEnabled(false);
			placementCount++;
		}
		
		placementGrid.setPlacingShip(true);
		
		if(e.getActionCommand().equals("Vertical Orientation"))
			placementGrid.setOrientation(placementGrid.VERTICAL_ORIENTATION);
		else if(e.getActionCommand().equals("Horizontal Orientation"))
			placementGrid.setOrientation(placementGrid.HORIZONTAL_ORIENTATION);
		
			
		
		
		if(e.getActionCommand().equals("Submit Placements")){
			if(placementCount < 5) {
				JOptionPane.showMessageDialog(placementFrame, "You must place all ships before submitting.");
			}
			else {
				placementFrame.dispose();
			
				Controller gameController = new Controller(data);
			}
		}
		
		
	}
	
	
}
