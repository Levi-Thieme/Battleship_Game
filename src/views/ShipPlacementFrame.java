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

import models.Node;

import java.awt.Color;
import javax.swing.JSeparator;

/**
 * This class is a JFrame that enables the user to place
 * his/her ships on the battlefield
 * @author Levi Thieme
 *
 */
public class ShipPlacementFrame extends JFrame implements ActionListener{
	private JButton subBtn1;
	private JButton subBtn2;
	private JButton destroyerBtn;
	private JButton cruiserBtn;
	private JButton carrierBtn;
	private ShipPlacementGrid shipPlacementGrid;
	private JButton verticalBtn;
	private JButton horizontalBtn;
	private JSeparator separator;
	
	public ShipPlacementFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 1300, 700);
		
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		panel.setMinimumSize(new Dimension(300, 10));
		getContentPane().add(panel, BorderLayout.EAST);
		
		carrierBtn = new JButton("Place Carrier");
		carrierBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(carrierBtn);
		carrierBtn.addActionListener(this);
		
		cruiserBtn = new JButton("Place Cruiser");
		cruiserBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(cruiserBtn);
		cruiserBtn.addActionListener(this);
		
		destroyerBtn = new JButton("Place Destroyer");
		destroyerBtn.setPreferredSize(new Dimension(300, 65));
		panel.add(destroyerBtn);
		destroyerBtn.addActionListener(this);
		
		subBtn1 = new JButton("Place Submarine (1)");
		subBtn1.setPreferredSize(new Dimension(300, 65));
		panel.add(subBtn1);
		subBtn1.addActionListener(this);
		
		subBtn2 = new JButton("Place Submarine (2)");
		subBtn2.setPreferredSize(new Dimension(300, 65));
		panel.add(subBtn2);
		subBtn2.addActionListener(this);
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(300, 100));
		panel.add(separator);
		
		verticalBtn = new JButton("Vertical Orientation");
		verticalBtn.setPreferredSize(new Dimension(280, 60));
		panel.add(verticalBtn);
		verticalBtn.addActionListener(this);
		
		horizontalBtn = new JButton("Horizontal Orientation");
		horizontalBtn.setPreferredSize(new Dimension(280, 60));
		panel.add(horizontalBtn);
		horizontalBtn.addActionListener(this);
		
		
		shipPlacementGrid = new ShipPlacementGrid();
		getContentPane().add(shipPlacementGrid, BorderLayout.CENTER);
		
	}
	
	public ArrayList<Node> getSelectedNodes(){
		return shipPlacementGrid.getSelectedNodes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == carrierBtn)
			shipPlacementGrid.setShipLength(5);
		else if(e.getSource() == cruiserBtn)
			shipPlacementGrid.setShipLength(4);
		else if(e.getSource() == destroyerBtn)
			shipPlacementGrid.setShipLength(3);
		else if(e.getSource() == subBtn1)
			shipPlacementGrid.setShipLength(2);
		else if(e.getSource() == subBtn2)
			shipPlacementGrid.setShipLength(2);
		
		shipPlacementGrid.setShipBeingPlaced(true);
		
		if(e.getSource() == verticalBtn)
			shipPlacementGrid.setOrientation(ShipPlacementGrid.VERTICAL_ORIENTATION);
		else if(e.getSource() == horizontalBtn)
			shipPlacementGrid.setOrientation(ShipPlacementGrid.HORIZONTAL_ORIENTATION);
	}
	
	

}
