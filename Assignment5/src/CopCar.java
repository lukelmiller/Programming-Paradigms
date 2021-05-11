import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car{

	private static Engine engine = new Engine("V8",30,100);
	private static int xRatio;
	private static int yRatio;
	//private int swit = 0;
	private int xMod = 1;
	private int yMod = 1;
	
	CopCar(){
		super("Police Vehicle", 5000, engine, "cop-car.jpg");
		Random rand = new Random();
		xRatio = rand.nextInt(6+6)-6;
		yRatio = rand.nextInt(6+6)-6;
		this.fillUp();
	
	}
	
	public void updateState(int width, int height) {

		if(this.getX() <= 0 || this.getX() >= width-60) {xMod = xMod * (-1);}
		if(this.getY() <= 0 || this.getY() >= height-60) {yMod = yMod *(-1);}
	    
	    int tempx = (xMod*xRatio);
	    int tempy = (yMod*yRatio);
	    
	    this.drive(2, tempx, tempy);

	}
	
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
	
	

	
}
