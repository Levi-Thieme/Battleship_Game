package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

public class BattleshipGUI extends JFrame{
	NodeGridPanel gridPane;
	
	public BattleshipGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 600);
		
		gridPane = new NodeGridPanel();
		gridPane.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(gridPane, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		NodeGridPanel nodeGridPanel = new NodeGridPanel();
		nodeGridPanel.setPreferredSize(new Dimension(500, 100));
		getContentPane().add(nodeGridPanel, BorderLayout.WEST);
		
		setVisible(true);
	}
	
	
	public NodeGridPanel getGridPane(){
		return gridPane;
	}

}
