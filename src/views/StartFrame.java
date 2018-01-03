package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.Controller;
import controllers.PlacementController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class StartFrame extends JFrame implements ActionListener {
	
	public StartFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(250, 50, 1500, 900);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Battleship");
		setIconImage(new ImageIcon("resources/battleship3.jpg").getImage());
		
		
		final BackgroundLabel backgroundLbl = new BackgroundLabel(new ImageIcon("resources/battleship3.jpg"));
		getContentPane().add(backgroundLbl, BorderLayout.CENTER);
		
		 addWindowListener( new WindowAdapter()
	        {
	            public void windowResized(WindowEvent evt)
	            {
	                backgroundLbl.repaint();
	            }
	        });
		 
		JButton continueBtn = new JButton("Continue");
		continueBtn.setPreferredSize(new Dimension(84, 40));
		continueBtn.addActionListener(this);
		
		getContentPane().add(continueBtn, BorderLayout.SOUTH);
        
        
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Continue")){
			this.setVisible(false);
			
			PlacementController placementController = new PlacementController();
		}
	}

}
