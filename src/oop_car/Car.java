/**
 * 
 */
package oop_car;

import java.util.Random;

/**
 * @author lfritz4
 *
 */
public class Car {
	
	private Engine engine;
	private Tire [] tires;
	
	public Car() {
		engine = new Engine();
		tires = new Tire[4];
		setTires();		
	}
	
	private void setTires() {
		tires[0] = new Tire(225, 70);
		tires[1] = new Tire(225, 70);
		tires[2] = new Tire(225, 70);
		tires[3] = new Tire(225, 70);
	}
	
	public void showTirePressure() {
		int count = 1;
		for(Tire t : tires) {
			System.out.printf("Tire %d: %d psi.\n", count++, t.getPressure());
		}
	}
	
	public void start() {
		engine.start();
	}
	
	public void stop() {
		engine.stop();
	}

}

class Engine{
	private int numCylinders;
	
	public Engine(int n) {
		numCylinders = n;
	}
	
	public Engine() {
		numCylinders = 4;
	}
	
	public void start() {
		System.out.printf("Starting the engine...\n");
	}
	
	public void stop() {
		System.out.printf("Turning off the engine.\n");
	}	
	
}

class Tire{


	public static Random rnd = new Random();
	
	private int tireWidth;
	private int aspectRatio;
	private int tirePressure;
	
	public Tire(int width, int ratio) {
		tireWidth = width;
		aspectRatio = ratio;
		tirePressure = 0;
		fill();
	}
	
	public void fill() {
		tirePressure = rnd.nextInt(10) + 35;
	}
	
	public int getPressure() {return tirePressure;}
	
	
	/**
	 * @return the tireWidth
	 */
	public int getTireWidth() {
		return tireWidth;
	}

	/**
	 * @param tireWidth the tireWidth to set
	 */
	public void setTireWidth(int tireWidth) {
		this.tireWidth = tireWidth;
	}

	/**
	 * @return the aspectRatio
	 */
	public int getAspectRatio() {
		return aspectRatio;
	}

	/**
	 * @param aspectRatio the aspectRatio to set
	 */
	public void setAspectRatio(int aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
}
