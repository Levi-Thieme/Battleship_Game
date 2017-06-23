package views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridLayout;

public class NodeGridPanel extends JPanel{
	JButton[][] buttonNodes;
	
	public NodeGridPanel(){
		setLayout(new GridLayout(10, 10));
		
		buttonNodes = new JButton[10][10];
		
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				
				JButton btnNewButton = new JButton("");
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
