package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import controller.Controller;

import java.awt.Dimension;

public class BattleshipGUI extends JFrame{
	NodeGridPanel userGridPane;
	NodeGridPanel AIGridPane;
	InfoPanel infoPane;
	
	public BattleshipGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 600);
		
		addPanes();
	}
	
	public void addPanes(){
		
		userGridPane = new NodeGridPanel();
		userGridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(userGridPane, BorderLayout.EAST);
		
		infoPane = new InfoPanel(userGridPane);
		infoPane.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(infoPane, BorderLayout.CENTER);
		
		AIGridPane = new NodeGridPanel();
		AIGridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(AIGridPane, BorderLayout.WEST);
		
		
		
	}
	
	
	public NodeGridPanel getUserGridPane(){
		return userGridPane;
	}
	public NodeGridPanel getAIGridPane(){
		return AIGridPane;
	}
	
	public InfoPanel getInfoPanel(){
		return infoPane;
	}

}
