package ships;

import models.Node;
import models.Ship;

public class Submarine extends Ship{
	
	public Submarine(String team){
		super(team, "Submarine", 2);
		super.setSymbol('S');
	}

}
