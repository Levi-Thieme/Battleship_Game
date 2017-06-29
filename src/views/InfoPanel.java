package views;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;

import models.Node;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfoPanel extends JPanel {
	private JButton placeShipBtn;
	private JButton clearSelectedNodesBtn;
	private boolean shipPlaced = false;
	private NodeGridPanel userGridPane;
	
	public InfoPanel(NodeGridPanel userGridPane){
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.userGridPane = userGridPane;
		
		JLabel lblBattleship = new JLabel("Battleship");
		lblBattleship.setAlignmentY(Component.TOP_ALIGNMENT);
		lblBattleship.setPreferredSize(new Dimension(50, 25));
		lblBattleship.setBorder(null);
		lblBattleship.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblBattleship);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		placeShipBtn = new JButton("Place Ship");
		placeShipBtn.setPreferredSize(new Dimension(140, 45));
		panel_2.add(placeShipBtn);
		placeShipBtn.addActionListener(new PlacementButtonListener());
		
		clearSelectedNodesBtn = new JButton("Clear Selected Nodes");
		panel_2.add(clearSelectedNodesBtn);
		clearSelectedNodesBtn.addActionListener(new PlacementButtonListener());
		
	}
	
	private class PlacementButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == placeShipBtn){
				shipPlaced = true;
			}
			else if(e.getSource() == clearSelectedNodesBtn){
				ArrayList<Node> selectedNodes = userGridPane.getSelectedNodes();
				
				for(Node n: selectedNodes){
					n.setBackground(new JButton().getBackground());
				}
				
				userGridPane.clearSelectedNodes();
			}
		}
		
	}
	
	public boolean getShipPlaced(){
		return shipPlaced;
	}
	
	public void setShipPlaced(boolean b){
		shipPlaced = b;
	}

}
