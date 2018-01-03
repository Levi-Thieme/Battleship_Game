package views;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.Controller;

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
import java.util.Observer;

public class InfoPanel extends JPanel {
	private NodeGridPanel userGridPane;
	
	public InfoPanel(NodeGridPanel userGridPane){
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.userGridPane = userGridPane;
		
		JLabel lblBattleship = new JLabel("Battleship");
		lblBattleship.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBattleship.setPreferredSize(new Dimension(50, 25));
		lblBattleship.setBorder(null);
		lblBattleship.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblBattleship);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
}
