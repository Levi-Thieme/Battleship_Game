package ships;

import models.Node;
import models.Ship;

public class Cruiser extends Ship {
	
	public Cruiser(String team){
		super(team, "Cruiser", 4);
		super.setSymbol('C');
	}

}
