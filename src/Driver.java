
import controllers.Controller;
import ships.Destroyer;
import views.BattleshipGUI;
import views.ShipPlacementFrame;
import views.StartFrame;


public class Driver {
	
	public static void main(String[] args){
		
		//StartFrame startF = new StartFrame();
		//startF.setVisible(true);
		//BattleshipGUI gui = new BattleshipGUI();
		
		//Controller controller = new Controller(gui);
		new ShipPlacementFrame().setVisible(true);
	}

}
