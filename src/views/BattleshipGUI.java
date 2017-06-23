package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

public class BattleshipGUI extends JFrame{
	NodeGridPanel gridPane;
	
	public BattleshipGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		
		gridPane = new NodeGridPanel();
		getContentPane().add(gridPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(panel, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	
	public NodeGridPanel getGridPane(){
		return gridPane;
	}

}
