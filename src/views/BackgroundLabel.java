package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundLabel extends JLabel{
	ImageIcon imageIcon;
	
	
    public BackgroundLabel(ImageIcon icon){
        super();
        this.imageIcon = icon;
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

}
