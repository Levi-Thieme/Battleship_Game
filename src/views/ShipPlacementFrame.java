package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import controllers.Controller;
import controllers.PlacementController;
import models.Node;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;

/**
 * This class is a JFrame that enables the user to place
 * ships on the battlefield
 * @author Levi Thieme
 *
 */
public class ShipPlacementFrame extends JFrame {
	private JButton subBtn1;
	private JButton subBtn2;
	private JButton destroyerBtn;
	private JButton cruiserBtn;
	private JButton carrierBtn;
	private ShipPlacementGrid shipPlacementGrid;
	private JButton verticalBtn;
	private JButton horizontalBtn;
	private JSeparator separator;
	private JButton submitBtn;
	private JSeparator separator_1;
	
	public ShipPlacementFrame(PlacementController placementController){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 1300, 700);
		
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		panel.setMinimumSize(new Dimension(300, 10));
		getContentPane().add(panel, BorderLayout.EAST);
		
		carrierBtn = new JButton("Place Carrier");
		carrierBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(carrierBtn);
		carrierBtn.addActionListener(placementController);
		
		cruiserBtn = new JButton("Place Cruiser");
		cruiserBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(cruiserBtn);
		cruiserBtn.addActionListener(placementController);
		
		destroyerBtn = new JButton("Place Destroyer");
		destroyerBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(destroyerBtn);
		destroyerBtn.addActionListener(placementController);
		
		subBtn1 = new JButton("Place Submarine (1)");
		subBtn1.setPreferredSize(new Dimension(300, 65));
		panel.add(subBtn1);
		subBtn1.addActionListener(placementController);
		
		subBtn2 = new JButton("Place Submarine (2)");
		subBtn2.setPreferredSize(new Dimension(300, 65));
		panel.add(subBtn2);
		subBtn2.addActionListener(placementController);
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(300, 45));
		panel.add(separator);
		
		verticalBtn = new JButton("Vertical Orientation");
		verticalBtn.setPreferredSize(new Dimension(280, 60));
		panel.add(verticalBtn);
		verticalBtn.addActionListener(placementController);
		
		horizontalBtn = new JButton("Horizontal Orientation");
		horizontalBtn.setPreferredSize(new Dimension(280, 60));
		panel.add(horizontalBtn);
		horizontalBtn.addActionListener(placementController);
		
		separator_1 =  new JSeparator();
		separator_1.setPreferredSize(new Dimension(300, 45));
		panel.add(separator_1);
		
		submitBtn = new JButton("Submit Placements");
		submitBtn.setFont(new Font("Dialog", Font.BOLD, 18));
		submitBtn.setPreferredSize(new Dimension(280, 60));
		submitBtn.addActionListener(placementController);
		panel.add(submitBtn);
		
		
		shipPlacementGrid = new ShipPlacementGrid();
		getContentPane().add(shipPlacementGrid, BorderLayout.CENTER);
		
	}
	
	public ArrayList<Node> getSelectedNodes(){
		return shipPlacementGrid.getSelectedNodes();
	}

	public ShipPlacementGrid getPlacementGrid(){
		return shipPlacementGrid;
	}
	
	public JButton getSubmitBtn(){
		return submitBtn;
	}
	
	
	

}
