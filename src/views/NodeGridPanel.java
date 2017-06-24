package views;

import javax.swing.JPanel;

import models.Node;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridLayout;

public class NodeGridPanel extends JPanel{
	Node[][] buttonNodes;
	
	public NodeGridPanel(){
		setLayout(new GridLayout(10, 10));
		
		buttonNodes = new Node[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				
				Node btnNewButton = new Node();
				btnNewButton.setPreferredSize(new Dimension(10, 10));
				btnNewButton.setText("");
				
				buttonNodes[row][column] = btnNewButton;
				add(btnNewButton);
				
			}
		}
		
		
	}

	public JButton[][] getButtonNodes() {
		return buttonNodes;
	}


}
