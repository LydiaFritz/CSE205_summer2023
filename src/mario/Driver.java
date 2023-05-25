package mario;

public class Driver {
	public static void main(String[] args) {
		Player mario = new Player("Mario");
		mario.powerUp(new SuperMushroom());
		mario.powerUp(new OneUpMushroom());
		mario.powerUp(new SuperMushroom());
		
		mario.applyPowerUp();
		mario.applyPowerUp();
		mario.applyPowerUp();

	}
}
