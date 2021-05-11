import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*; 
import java.util.*;

class Model
{
    private Car car;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();



    Model() throws IOException {
    	synchronized(sprites)
    	{
	    	Bank monkeys = new Bank();
	    	sprites.add(monkeys);
	    	
    	}
    	
    	
    }
    
    public void initialize() {
    	synchronized(sprites)
    	{
	    	sprites.clear();
	    	Bank monkeys = new Bank();
	    	sprites.add(monkeys);
	    	RobberCar.reset(); 
    	
    	}
    	
    }
    
    public void setModel(int x, int y) {
    	synchronized(sprites)
    	{
	    	if(sprites.size()%2!=0) {
	    		car = new CopCar();
	    		car.setX(x);
	    		car.setY(y);
	    	}
	    	else {
	    		car = new RobberCar();
	    		car.setX(300);
	    		car.setY(300);
	    	}
		
			sprites.add(car);
    	}
    }
    

    public void updateScene(int width, int height) {
    	synchronized(sprites)
    	{
	    	for(Sprite sprite1: sprites) {
	    		sprite1.updateState(width,height);
	    		if(sprite1 instanceof CopCar) {
		    		for(Sprite spriteComparer: sprites) {
		    			if(spriteComparer instanceof RobberCar&& sprite1.overlaps(spriteComparer)) {
		    					((RobberCar) spriteComparer).captured();
		    					
		    			}
		    		}
	    		}
	    		
	    	
	    	}
	    	Iterator iter = sprites.iterator();
	    	while (iter.hasNext()) {
	    		
	    	    Sprite s = (Sprite) iter.next();
	    		if(s instanceof RobberCar && ((RobberCar) s).hasEscaped()) {
	    			
	    			iter.remove();
	    			System.out.println("I'm free!");
	    		}
	    	}
    	}
    }
    public int getEscaped() {

    	int escaped = RobberCar.getEscaped();
    	return escaped;
    }
    public int getCaptured() {

    	int captured = RobberCar.getCaptured();
    	return captured;
    	
    	
    }
    

    public void update(Graphics g) {
    	synchronized(sprites)
    	{
	    	for(Sprite sp: sprites) {

	    		sp.updateImage(g);

	    	}
    	}
	}
    
}
