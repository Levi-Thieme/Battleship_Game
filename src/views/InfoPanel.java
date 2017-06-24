package views;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class InfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	public InfoPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblBattleship = new JLabel("Battleship");
		lblBattleship.setBorder(null);
		lblBattleship.setFont(new Font("Dialog", Font.BOLD, 24));
		add(lblBattleship);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblOpponentShips = new JLabel("Opponent Ships:");
		panel.add(lblOpponentShips);
		lblOpponentShips.setFont(new Font("Dialog", Font.BOLD, 18));
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		
		JLabel lblPlayerShips = new JLabel("Player Ships:");
		panel_1.add(lblPlayerShips);
		lblPlayerShips.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPlayerShips.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerShips.setFont(new Font("Dialog", Font.BOLD, 18));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
	}

}
