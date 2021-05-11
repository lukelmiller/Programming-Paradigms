import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

class Model
{
    private Car car;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    Model() throws IOException {
    	
//    	if(sprites.size()==0 || sprites.size()%2==0) {
//    		car = new CopCar();
//    	}
//    	else {
//    		car = new RobberCar();
//    	}
    	
    	setModel(500,350);
    	
    	
    }
    
    public void setModel(int x, int y) {
    	if(sprites.size()==0 || sprites.size()%2==0) {
    		car = new CopCar();
    	}
    	else {
    		car = new RobberCar();
    	}
		car.setX(x);
		car.setY(y);
		sprites.add(car);
    }
    public void refill() {
    	for(Sprite sp: sprites) {
    		Car cary = (Car)sp;
    		cary.fillUp();
    	}
    }
    
    

    public void update(Graphics g) {
    	for(Sprite sp: sprites) {
    		Car cary = (Car)sp;
    		cary.update(g);
    		//sp.update(g);
    	}
    }
    
}
