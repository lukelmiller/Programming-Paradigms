import java.awt.Graphics;
import java.util.*;

public class RobberCar extends Car{

	private static Engine engine = new Engine("V6",20,200);
	private int xRatio;
	private int yRatio;
	RobberCar(){
		super("Joker-Mobile", 20, engine, "red-car.jpg");
		Random rand = new Random();
		xRatio = rand.nextInt(6+6)-6;
		yRatio = rand.nextInt(6+6)-6;
		this.fillUp();
		
	}
	public void update(Graphics g) {
        // Move the sprite
		this.drive(40, xRatio, yRatio);
//		setX(getX() + xRatio);
//		setY(getY() + yRatio);
		super.update(g);

	}
}
