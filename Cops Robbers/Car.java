import java.awt.Graphics;

import javax.swing.JOptionPane;

// LUKE MILLER
// ASSI 3
public class Car extends Sprite {
	
	private String description;
//	private int x = 0;
//	private int y = 0;
	private GasTank gassy;
	private Engine enggy;
	
	Car(String description, int capacity, Engine enggy,String jpgName){
		super(jpgName);
		
		
		
		if(description.length() == 0) {
			this.description = "Generic car";
		}
		else {
			this.description = description;
		}
		if(enggy==null) {
			this.enggy = new Engine("",0,0);
		}
		else {
			this.enggy = enggy;
		}
		gassy = new GasTank(capacity);
	}


	public String getDescription() {
		
		String ret = description + " (engine: " + enggy.getDescription() +"), fuel: " + String.format("%.2f", gassy.getLevel()) + "/" + gassy.getCapacity() +", location: (" + getX() +"," + getY() +")";
		return ret;
	}
	public double getFuelLevel() {
		return gassy.getLevel();
	}
	public int getMPG() {
		return enggy.getMpg();
	}
	public void fillUp() {
		gassy.setLevel(gassy.getCapacity());
	}
	public int getMaxSpeed() {
		return enggy.getMaxSpeed();
	}
	public double drive(int distance, double xRatio, double yRatio) {
		double gas = (double)distance / (double)enggy.getMpg();
		double ratio = (xRatio*xRatio)+(yRatio*yRatio);
		ratio = java.lang.Math.sqrt(ratio);
		if(gas > gassy.getLevel()) {
			double ret = gassy.getLevel()*enggy.getMpg();
			//System.out.println("Ran out of gas after driving "+ gassy.getLevel()*enggy.getMpg() +" miles.");
			//JOptionPane.showMessageDialog(null, "Ran out of gas after driving "+ gassy.getLevel()*enggy.getMpg() +" mile(s).");
			gassy.setLevel(0);
			
			double lineX = ((xRatio/ratio) * ret);
			double lineY = ((yRatio/ratio) * ret);
			
			 
			setX((int)(lineX + getX()));
			setY((int)(lineY + getY()));
			
			return ret;
	 	}
		else {
		
		
			double lineX = ((xRatio/ratio)* distance);
			double lineY = ((yRatio/ratio) * distance);
		
			setX((int)(lineX + getX()));
			setY((int)(lineY + getY()));
			
			gassy.setLevel(gassy.getLevel()-gas);
			return distance;
		}
	}
	
	public void updateImage(Graphics g) {
        // Move the sprite
//		setX(getX() + 1);
//		setY(getY() + 1);
		super.updateImage(g);

	}
	
	
	
	
	
	
}
