package ships;

import models.Point;
import models.Ship;


public class Destroyer extends Ship {
	
	public Destroyer(String team){
		super(team, "Destroyer", 3);
		super.setSymbol('D');
	}
	
}
