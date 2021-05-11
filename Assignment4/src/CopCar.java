import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car{

	private static Engine engine = new Engine("V8",30,100);
	private static int xRatio;
	private static int yRatio;
	
	CopCar(){
		super("Police Vehicle", 30, engine, "cop-car.jpg");
		Random rand = new Random();
		xRatio = rand.nextInt(6+6)-6;
		yRatio = rand.nextInt(6+6)-6;
		this.fillUp();
	
	}
	public void update(Graphics g) {
        // Move the sprite
		this.drive(20, xRatio, yRatio);
//		setX(getX() + xRatio);
//		setY(getY() + yRatio);
		super.update(g);

	}
	
}
