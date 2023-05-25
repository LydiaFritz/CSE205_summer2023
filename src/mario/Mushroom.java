package mario;

public abstract class Mushroom {

	private int duration;
	
	public Mushroom() {duration = 5;}
	
	public int getDuration() {return duration;}
	
	public void setDuration(int duration) {this.duration = duration;}
	
	public abstract String getType();
	public abstract String getAction();
}

class SuperMushroom extends Mushroom{
	
	public SuperMushroom() {
		super();
		setDuration(6);
	}	
	public String getType() {return "Super Mushroom";}
	public String getAction() {return "Mario gets BIG";}
}

class OneUpMushroom extends Mushroom{
	
	public OneUpMushroom() {
		super();
		setDuration(0);
	}
	
	public String getType() {return "1-up Mushroom";}
	public String getAction() {return "Mario gets another life.";}
}
