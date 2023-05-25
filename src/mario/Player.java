package mario;

import java.util.ArrayList;

public class Player {

	private ArrayList<Mushroom> powerUps;
	private String name;
	private int numLives;
	
	public Player(String n) {
		name = n;
		numLives = 3;
		powerUps = new ArrayList<Mushroom>();
	}
	
	public void powerUp(Mushroom m) {
		powerUps.add(m);
	}
	
	public void applyPowerUp() {
		//apply first powerup in the list
		Mushroom m = powerUps.remove(0);
		System.out.println(m.getType() + " applied.");
		System.out.println(m.getAction());
	}
	
}
