import java.awt.Graphics;
import java.util.*;

public class RobberCar extends Car{

	private static Engine engine = new Engine("V6",20,200);
	private int xRatio;
	private int yRatio;
	private static int caughtCars = 0;
	private static int escapedTotal = 0;
	private boolean state = false;
	private boolean escaped = false;
	RobberCar(){
		super("Joker-Mobile", 5000, engine, "red-car.jpg");
		Random rand = new Random();
		xRatio = rand.nextInt(6+6)-6;
		yRatio = rand.nextInt(6+6)-6;
		this.fillUp();

		
	}
	
	public void captured() {
		if(!state) {
			this.setImage("jail.jpg");
			state = true;
			caughtCars++;
		}
	}
	public boolean isCaptured() {
		return state;
	}
	public boolean hasEscaped() {
		return escaped;
	}
	public static int getEscaped() {
		return escapedTotal;
	}
	public static int getCaptured() {
		return caughtCars;
	}
	public static void reset() {
		caughtCars = 0 ;
		escapedTotal = 0;
	}
	
	
	public void updateState(int width, int height) {
		
		if((this.getX() <= -60 || this.getY() <= -60 || this.getX() >= width || this.getY() >= height) && !escaped) {
			escaped = true;
			escapedTotal++;
		}

		if(!state) {
			this.drive(4, xRatio, yRatio);
		}
	}
	
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
}
