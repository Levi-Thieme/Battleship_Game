package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

public class BattleshipGUI extends JFrame{
	NodeGridPanel userGridPane;
	NodeGridPanel AIGridPane;
	
	public BattleshipGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 600);
		
		addPanes();
		
		setVisible(true);
	}
	
	public void addPanes(){
		
		userGridPane = new NodeGridPanel();
		userGridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(userGridPane, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(panel, BorderLayout.CENTER);
		
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

}
