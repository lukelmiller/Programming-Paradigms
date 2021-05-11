// LUKE MILLER
// ASSI 3

import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class Assignment3 {
	static int legs;
	static int[] x = new int[10] ;
	static int[] y = new int[10];
	
	private static void prompt() {
		
		String cDesription = JOptionPane.showInputDialog("Please enter the car's desription");
		int capacity = intPrompt("Please enter the fuel tank capacity", true);
		String eDesription = JOptionPane.showInputDialog("Please enter the engine's description");
		int mpg = intPrompt("Please enter the miles per gallon", true);
		int maxSpeed = intPrompt("Please enter the max speed", true);
		
		Engine thatCould = new Engine(eDesription, mpg, maxSpeed);
		Car vroom = new Car(cDesription,capacity,thatCould);
		vroom.fillUp();
		JOptionPane.showMessageDialog(null, vroom.getDescription());
		
		int legs = lPrompt("Please enter the number of legs on the trip");
		for(int i = 0; i<legs;i++) {
			int distance = intPrompt("Please enter the distance for leg " + (i+1)+":",true);
			double xRatio = dPrompt("Please enter the x ratio for leg " + (i+1) +":");
			double yRatio = dPrompt("Please enter the y ratio for leg " + (i+1)+":");
			
			vroom.drive(distance, xRatio, yRatio);
			x[i] = vroom.getX();
			y[i] = vroom.getY();
			
//			System.out.println("x[" +i +"] = "+x[i]);
//			System.out.println("y[" +i +"] = "+y[i]);
//			System.out.println("legs: " + legs);
		}
		//System.out.println("legs: " + legs);
		
			graph(legs,x,y);
	}
	private static int intPrompt(String prompty, boolean positive) {
		int ret = 0;
		try {
			if(positive) {
				while(ret<=0) {
					String capacity = JOptionPane.showInputDialog(prompty);
					ret = Integer.parseInt(capacity);
				}
			}
		    else {
		    	String capacity = JOptionPane.showInputDialog(prompty);
				ret = Integer.parseInt(capacity);
		    }
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.");
			System.exit(0);
		}
		return ret;
	}
	private static double dPrompt(String prompty) {
		double ret = 0;
		try {
		
		    	String capacity = JOptionPane.showInputDialog(prompty);
				ret = Double.parseDouble(capacity);
		    
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.");
			System.exit(0);
		}
		return ret;
	}
	private static int lPrompt(String prompty) {
		int ret = 0;
		do {
			ret = intPrompt(prompty, true);
		}while(ret>10 && ret<=0);
		return ret;
	}
	private static void graph(int legs, int[] x, int[] y) {
		
//		x[0]= 300;
//		x[1]= 200;
//		
//		y[0]= 400;
//		y[1] = 100;
//		legs = 2;
		
//		for(int i = 0; i<legs;i++) {
//			System.out.println("x[" +i +"] = "+x[i]);
//			System.out.println("y[" +i +"] = "+y[i]);
//
//		}
//		System.out.println("legs: " + legs);
		
		
		
		DrivePanel trip = new DrivePanel(legs, x, y);
		JFrame frame = new JFrame("Trip");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(trip);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	
	
	

	public static void main(String[] args)
	{
		
		
		
		
		prompt();
		//graph();
	}
}
