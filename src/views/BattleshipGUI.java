package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import controllers.Controller;

import java.awt.Dimension;


/**
 * This Class represents the Battleship GUI
 * @author Levi Thieme
 *
 */
public class BattleshipGUI extends JFrame{
	NodeGridPanel userGridPane;
	NodeGridPanel AIGridPane;
	InfoPanel infoPane;
	
	public BattleshipGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 600);
		
		addPanes();
	}
	
	/**
	 * Adds panes to the Frame
	 */
	public void addPanes(){
		
		userGridPane = new NodeGridPanel();
		userGridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(userGridPane, BorderLayout.WEST);
		
		infoPane = new InfoPanel(userGridPane);
		infoPane.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(infoPane, BorderLayout.CENTER);
		
		AIGridPane = new NodeGridPanel();
		AIGridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(AIGridPane, BorderLayout.EAST);
		
		
		
	}
	
	/**
	 * 
	 * @return A reference to userGridPane
	 */
	public NodeGridPanel getUserGridPane(){
		return userGridPane;
	}
	
	/**
	 * 
	 * @return A reference to AIGridPane
	 */
	public NodeGridPanel getAIGridPane(){
		return AIGridPane;
	}
	
	/**
	 * 
	 * @return A reference to infoPane
	 */
	public InfoPanel getInfoPanel(){
		return infoPane;
	}

}
